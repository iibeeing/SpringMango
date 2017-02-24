package com.mango.jtt.model;

import com.mango.jtt.system.entity.PagedResult;

public class Users {
	public PagedResult<User> list;

	public PagedResult<User> getList() {
		return list;
	}
	public void setList(PagedResult<User> list) {
		this.list = list;
	}

}
