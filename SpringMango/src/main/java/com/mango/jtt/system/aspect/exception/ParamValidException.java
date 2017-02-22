package com.mango.jtt.system.aspect.exception;

import java.util.List;

public class ParamValidException extends Exception {
	private static final long serialVersionUID = 1L;
	private List<FieldError> fieldErrors;

	public ParamValidException(List<FieldError> errors) {
		this.fieldErrors = errors;
	}
}
