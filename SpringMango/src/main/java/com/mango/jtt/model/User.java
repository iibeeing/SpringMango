package com.mango.jtt.model;

import org.hibernate.validator.constraints.NotEmpty;

public class User extends PageFilter{

	private int id;
	//@NotEmpty(message = "姓名不能为空")
	private String name;
	private String password;

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


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, password=%s]", id, name,
				password);
	}

}
