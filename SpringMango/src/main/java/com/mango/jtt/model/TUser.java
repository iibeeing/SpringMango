package com.mango.jtt.model;

public class TUser implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;

	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
