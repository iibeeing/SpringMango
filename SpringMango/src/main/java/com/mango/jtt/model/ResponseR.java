package com.mango.jtt.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author BEE
 * 返回给前端JSON格式
 * @param <T>
 */
public class ResponseR<T> {
	
	private ResponseEntity<ListModel<T>> responseEntity = new ResponseEntity<ListModel<T>>(HttpStatus.NO_CONTENT);

	public ResponseEntity<ListModel<T>> getResponseEntity() {
		return responseEntity;
	}

	public void setResponseEntity(ResponseEntity<ListModel<T>> responseEntity) {
		this.responseEntity = responseEntity;
	}

	public ResponseR(ResponseEntity<ListModel<T>> responseEntity) {
		super();
		this.responseEntity = responseEntity;
	}

}
