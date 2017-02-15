/**
 * 
 */
package com.mango.jtt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Valid;
import com.mango.jtt.model.ResponseResult;
import com.mango.jtt.model.User;
import com.mango.jtt.util.ConstUtil;
import com.mango.jtt.util.ValidUtil;

@Controller
public class PageController {

	@RequestMapping({ "/", "/index" })
	public String index() throws Exception {
		return "index";
	}

	@RequestMapping({ "/toadd", "/toadd" })
	public String add() throws Exception {
		return "add";
	}

	@RequestMapping({ "/user", "/user" })
	public String user() throws Exception {
		return "user";
	}

	@RequestMapping({ "/useredit", "/useredit" })
	public String useradd() throws Exception {
		return "useredit";
	}

	@RequestMapping("/add")
	@ResponseBody
	public ResponseResult add(@Valid User model, BindingResult br,
			HttpServletRequest req) {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		System.out.println("name " + name);
		System.out.println("password " + password);
		System.out.println("user " + model.toString());

		ResponseResult rr = new ResponseResult();
		if (name == null && password == null) {
			rr.setStatusCode(ConstUtil.RESPONSECODE_INPUTPARAMNULL);
			return rr;
		}
		if (ValidUtil.isValid(model, br, rr)) {
			/*
			 * if (qxdm != null && !qxdm.equals("")) { qxdms = new String[] {
			 * qxdm }; }
			 */
			try {
				// kaikaoService.add(model, rr, qxdms);
				rr.setStatusCode(ConstUtil.RESPONSECODE_SUCCESS);
			} catch (Exception e) {
				// LOGGER.error(e.getMessage());
				rr.setStatusCode(ConstUtil.RESPONSECODE_FAIL);
			}
		}
		return rr;
	}

	@RequestMapping("/update")
	@ResponseBody
	// @Permission(permissionRoleCode = { ConstUtil.ROLECODE_SA })
	public ResponseResult update(@Valid User model, BindingResult br,
			HttpServletRequest req) {
		String qxdm = req.getParameter("qxdms");
		String[] qxdms = req.getParameterValues("qxdms[]");
		ResponseResult rr = new ResponseResult();
		if (qxdm == null && qxdms == null) {
			rr.setStatusCode(ConstUtil.RESPONSECODE_INPUTPARAMNULL);
			return rr;
		}
		if (ValidUtil.isValid(model, br, rr)) {
			if (qxdm != null && !qxdm.equals("")) {
				qxdms = new String[] { qxdm };
			}
			try {
				// kaikaoService.add(model, rr, qxdms);
			} catch (Exception e) {
				// LOGGER.error(e.getMessage());
				rr.setStatusCode(ConstUtil.RESPONSECODE_FAIL);
			}
		}
		return rr;
	}
}
