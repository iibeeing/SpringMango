package com.mango.jtt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mango.jtt.model.ResponseResult;
import com.mango.jtt.model.User;
import com.mango.jtt.service.IUserService;
import com.mango.jtt.util.ConstUtil;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult index(@Valid User model, BindingResult br,
			HttpServletRequest req) throws Exception {
		ResponseResult rr = new ResponseResult();
		rr = userService.list(model);
		System.out.println("index -- " + rr);
		return rr;
	}

/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult index2(@Valid User model, BindingResult br,
			HttpServletRequest req) throws Exception {
		ResponseResult rr = new ResponseResult();
		rr = userService.list(model);
		System.out.println("index2 -- " + rr);
		return rr;
	}*/

	/** 　进入新增　 */
	@RequestMapping(value = "/new")
	public String toCreate(HttpServletRequest req) throws Exception {
		System.out.println("toCreate -- ");
		return "user";
	}

	/** 　显示　 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult show(@PathVariable Integer id, HttpServletRequest req)
			throws Exception {
		ResponseResult rr = new ResponseResult();
		rr = userService.get(id);
		System.out.println("show -- " + rr);
		return rr;
	}

	/** 　保存新增　 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult create(User model, HttpServletRequest req)
			throws Exception {
		ResponseResult rr = new ResponseResult();
		rr = userService.save(model);
		System.out.println("create -- " + rr);
		return rr;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseResult edit(@PathVariable Integer id, User model,
			HttpServletRequest req) throws Exception {
		ResponseResult rr = new ResponseResult();
		String oid = req.getParameter("id");
		String oname = req.getParameter("name");
		String opassword = req.getParameter("password");

		System.out.println(oid + " -- " + oname + " -- " + opassword);
		System.out.println(model.toString());
		if (id == model.getId()) {
			rr = userService.saveOrUpdate(model);
		} else {
			rr.setStatusCode(ConstUtil.RESPONSECODE_INPUTPARAMNULL);
			rr.setMsg("参数不匹配，请重试");
		}

		System.out.println("edit -- " + rr);
		return rr;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseResult delete(@PathVariable Integer id,
			HttpServletRequest req) throws Exception {
		ResponseResult rr = new ResponseResult();
		rr = userService.delete(id);
		System.out.println("delete -- " + "id -- " + id +   rr);
		return rr;
	}
}
