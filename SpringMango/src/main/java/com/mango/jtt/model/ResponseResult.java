package com.mango.jtt.model;

public class ResponseResult {
	
	private int statusCode;
	private String msg = "";
	private Object result;
	private String url;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return String.format(
				"ResponseResult [statusCode=%s, msg=%s, result=%s, url=%s]",
				statusCode, msg, result, url);
	}

}
