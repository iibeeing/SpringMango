package com.mango.jtt.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.mango.jtt.model.ResponseResult;
import com.mango.jtt.model.UserT;
import com.mango.jtt.service.IUserTService;
import com.mango.jtt.util.ConstUtil;
import com.mango.jtt.util.R;
import com.mango.jtt.util.ShiroUtils;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private Producer producer;
	@Autowired
	private IUserTService userTService;

	/** 　保存新增　 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult check(UserT model, HttpServletRequest req) {
		ResponseResult rr = new ResponseResult();
		rr.setStatusCode(ConstUtil.RESPONSECODE_FAIL);
		System.out.println(model);
		if (model.getUserName() != null && model.getUserName() != null) {
			try {
				Subject subject = ShiroUtils.getSubject();
				System.out.println(subject);
				// sha256加密
				UsernamePasswordToken token = new UsernamePasswordToken(
						model.getUserName(), model.getPassword());
				System.out.println(token);
				subject.login(token);
				rr.setStatusCode(ConstUtil.RESPONSECODE_SUCCESS);
				rr.setMsg("登录成功");
				rr.setUrl("main.jsp");
				req.getSession().setAttribute("user", subject);
			} catch (UnknownAccountException e) {
				rr.setMsg(e.getMessage());
			} catch (IncorrectCredentialsException e) {
				rr.setMsg(e.getMessage());
			} catch (LockedAccountException e) {
				rr.setMsg(e.getMessage());
			} catch (AuthenticationException e) {
				rr.setMsg(e.getMessage());
			}
		} else {
			rr.setStatusCode(ConstUtil.RESPONSECODE_INPUTPARAMERR);
			rr.setMsg("参数错误，请重新填写");
		}
		return rr;
	}

	@RequestMapping("captcha.jpg")
	public void captcha(HttpServletResponse response) throws ServletException,
			IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		// 生成文字验证码
		String text = producer.createText();
		// 生成图片验证码
		BufferedImage image = producer.createImage(text);
		// 保存到shiro session
		ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
	}

	/**
	 * 登录
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/login", method = RequestMethod.POST)
	public R login(String username, String password, String captcha)
			throws IOException {
		/*
		 * String kaptcha =
		 * ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY); if
		 * (!captcha.equalsIgnoreCase(kaptcha)) { return R.error("验证码不正确"); }
		 */

		try {
			Subject subject = ShiroUtils.getSubject();
			// sha256加密
			password = new Sha256Hash(password).toHex();
			UsernamePasswordToken token = new UsernamePasswordToken(username,
					password);
			subject.login(token);
		} catch (UnknownAccountException e) {
			return R.error(e.getMessage());
		} catch (IncorrectCredentialsException e) {
			return R.error(e.getMessage());
		} catch (LockedAccountException e) {
			return R.error(e.getMessage());
		} catch (AuthenticationException e) {
			return R.error("账户验证失败");
		}

		return R.ok();
	}

	/**
	 * 退出
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		ShiroUtils.logout();
		return "redirect:login.html";
	}
}
