package com.mango.jtt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mango.jtt.model.ResponseResult;
import com.mango.jtt.model.UserT;
import com.mango.jtt.service.IUserTService;
import com.mango.jtt.util.ConstUtil;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private IUserTService userTService;

	/** 　保存新增　 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult create(UserT model, HttpServletRequest req)
			throws Exception {
		ResponseResult rr = new ResponseResult();
		System.out.println(model);
		if(model.getUserName() != null && model.getUserName() != null){
			rr = userTService.login(model);
		}else{
			rr.setStatusCode(ConstUtil.RESPONSECODE_INPUTPARAMERR);
			rr.setMsg("参数错误，请重新填写");
		}
		System.out.println("create -- " + rr);
		return rr;
	}
	
	
}
