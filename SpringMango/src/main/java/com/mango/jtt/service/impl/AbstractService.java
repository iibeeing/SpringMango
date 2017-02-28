package com.mango.jtt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService<T extends BaseService> {
	@Autowired
	protected T provider;
	public Boolean getObject(Integer id) {
		return provider.getObject(id);
	}
}
