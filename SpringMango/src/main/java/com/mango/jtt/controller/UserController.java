package com.mango.jtt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mango.jtt.model.ResponseResult;
import com.mango.jtt.model.User;
import com.mango.jtt.model.UserT;
import com.mango.jtt.service.IUserService;
import com.mango.jtt.service.IUserTService;
import com.mango.jtt.util.ConstUtil;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserTService userTService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult index(@Valid User model, BindingResult br, HttpServletRequest req) throws Exception {
		ResponseResult rr = new ResponseResult();
		rr = userService.list(model);
		System.out.println("index -- " + rr);
		return rr;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseResult index2(@Valid User model, BindingResult br, HttpServletRequest req) throws Exception {
		ResponseResult rr = new ResponseResult();
		List<UserT> list = userTService.selectAll();
		rr.setResult(list);
		System.out.println("index2 -- " + list);
		return rr;
	}

	/** 进入新增 */
	@RequestMapping(value = "/new")
	public String toCreate(HttpServletRequest req) throws Exception {
		System.out.println("toCreate -- ");
		return "user";
	}

	/** 显示 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult show(@PathVariable Integer id, HttpServletRequest req) throws Exception {
		ResponseResult rr = new ResponseResult();
		rr = userService.get(id);
		System.out.println("show -- " + rr);
		return rr;
	}

	/** 保存新增 */
	/*
	 * @RequestMapping(method = RequestMethod.POST)
	 * 
	 * @ResponseBody public ResponseResult create(User model, HttpServletRequest
	 * req) throws Exception { ResponseResult rr = new ResponseResult(); //rr =
	 * userService.save(model); rr = userTService.save(model);
	 * System.out.println("create -- " + rr); return rr; }
	 */

	@SuppressWarnings("finally")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult create(@NotNull String username, @NotNull String password, HttpServletRequest req) {
		ResponseResult rr = new ResponseResult();
		try {
			User model = new User();
			System.out.println(username + " --- " + password);
			model.setName(username);
			model.setPassword(password);
			rr = userTService.save(model);
			System.out.println("create -- " + rr);

		} catch (UndeclaredThrowableException e) {
			// TODO: handle exception
			Throwable throwable = e.getUndeclaredThrowable(); // 获得实际异常
			System.out.println(throwable.getMessage());
			System.out.println(throwable.toString());
			System.out.println("UndeclaredThrowableException -- " + e.getMessage());
		} catch (Exception e) {
			System.out.println("UndeclaredThrowableException -- " + e.getMessage());
		} finally {
			return rr;
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseResult edit(@PathVariable Integer id, User model, HttpServletRequest req) throws Exception {
		ResponseResult rr = new ResponseResult();
		String oid = req.getParameter("id");
		String oname = req.getParameter("name");
		String opassword = req.getParameter("password");

		System.out.println(oid + " -- " + oname + " -- " + opassword);
		System.out.println(model.toString());
		if (id == model.getId()) {
			// rr = userService.saveOrUpdate(model);
			rr = userTService.saveOrUpdate(model);
		} else {
			rr.setStatusCode(ConstUtil.RESPONSECODE_INPUTPARAMNULL);
			rr.setMsg("参数不匹配，请重试");
		}
		System.out.println("edit -- " + rr);
		return rr;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseResult delete(@PathVariable Integer id, HttpServletRequest req) throws Exception {
		ResponseResult rr = new ResponseResult();
		rr = userService.delete(id);
		System.out.println("delete -- " + "id -- " + id + rr);
		return rr;
	}
}
