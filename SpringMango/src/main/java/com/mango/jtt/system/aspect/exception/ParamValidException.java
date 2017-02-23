package com.mango.jtt.system.aspect.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindException;

public class ParamValidException extends Exception {
	private List<FieldError> fieldErrors = new ArrayList<FieldError>();

	/**
	 *
	 */
	private static final long serialVersionUID = -716441870779206738L;

	@Override
	public String getMessage() {
		return fieldErrors.toString();
	}

	public ParamValidException(List<FieldError> errors) {
		this.fieldErrors = errors;
	}

	public ParamValidException(BindException ex) {
		this.fieldErrors = bindExceptionToFieldError(ex);
	}

	private List<FieldError> bindExceptionToFieldError(BindException ex) {
		/*JDK 1.8及以上的版本*/
		/*		return ex.getFieldErrors().stream().map(f -> {
			FieldError error = new FieldError();
			error.setName(f.getObjectName() + "." + f.getField());
			error.setMessage(f.getDefaultMessage());
			return error;
		}).collect(Collectors.toList());*/
		
		/*JDK 1.8以下的版本*/
		List<org.springframework.validation.FieldError> list = ex.getFieldErrors();
		List<FieldError> nlist = new ArrayList<FieldError>();
		for (org.springframework.validation.FieldError fieldError : list) {
			FieldError error = new FieldError();
			error.setName(fieldError.getObjectName() + "." + fieldError.getField());
			error.setMessage(fieldError.getDefaultMessage());
			nlist.add(error);
		}
		return nlist;
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	@Override
	public String toString() {
		return "ParamValidException [fieldErrors=" + fieldErrors + "]";
	}

}
