package com.mango.jtt.controller;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.mango.jtt.model.ListModel;
import com.mango.jtt.model.ResponseR;
import com.mango.jtt.model.ResponseResult;
import com.mango.jtt.system.aspect.exception.ParamValidException;
import com.mango.jtt.system.entity.PagedResult;
import com.mango.jtt.util.ConstUtil;

@RestController
public class BaseController<T> {
	protected ResponseEntity<ListModel<T>> responseEntity = new ResponseEntity<ListModel<T>>(HttpStatus.INTERNAL_SERVER_ERROR);
	protected ResponseR<T> responser = new ResponseR<T>(responseEntity);
	public ResponseEntity<ListModel<T>> getResponseEntity() {
		return responseEntity;
	}

	public void setResponseEntity(ResponseEntity<ListModel<T>> responseEntity) {
		this.responseEntity = responseEntity;
	}

	public void setResponseEntityList(List<T> list) {
		ListModel<T> modelList = new ListModel<T>();
		PagedResult<T> pr = new PagedResult<T>();
		pr.setDataList(list);
		modelList.setPr(pr);
		responseEntity = new ResponseEntity<ListModel<T>>(modelList,HttpStatus.NO_CONTENT);
		//responser.setResponseEntity(responseEntity);
	}

	/**
	 * @param msg
	 * @param status
	 * 向前端发送消息
	 */
	public void setMsg(String msg,HttpStatus status){
		ListModel<T> modelList = new ListModel<T>();
		modelList.setMsg(new StringBuilder(msg));
		responseEntity = new ResponseEntity<ListModel<T>>(modelList,status);
		responser.setResponseEntity(responseEntity);
	}
	
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
