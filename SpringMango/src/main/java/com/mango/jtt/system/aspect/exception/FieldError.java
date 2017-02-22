package com.mango.jtt.system.aspect.exception;

public class FieldError {
    private String name;
    private String message;
    // getter / setter...
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "FieldError [name=" + name + ", message=" + message + "]";
	}
    
    
}
