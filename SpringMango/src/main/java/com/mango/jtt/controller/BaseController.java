package com.mango.jtt.controller;

import java.lang.reflect.UndeclaredThrowableException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mango.jtt.model.ResponseResult;
import com.mango.jtt.system.aspect.exception.ParamValidException;
import com.mango.jtt.util.ConstUtil;

@RestController
public class BaseController {
	/**
	 * 该类用于处理切面验证数据所抛出的异常到前台
	 * 
	 * @param ex
	 * @param response
	 * @return
	 */
	@ExceptionHandler(UndeclaredThrowableException.class)
	@ResponseBody
	public ResponseResult undeclaredThrowableException(UndeclaredThrowableException ex, HttpServletResponse response) {
		Throwable throwable = ex.getUndeclaredThrowable(); // 获得实际异常
		ResponseResult rr = new ResponseResult();
		if (throwable instanceof ParamValidException) { // 如果是我们自定义异常就调用自定义异常的处理方法
			rr.setStatusCode(ConstUtil.RESPONSECODE_FAIL);
			rr.setMsg(throwable.toString());
		}
		System.out.println("- - 异常 undeclaredThrowableException - - " + ex.getMessage());
		return rr;
	}
}
