package com.mango.jtt.model;

import com.mango.jtt.system.entity.Messager;
import com.mango.jtt.system.entity.PagedResult;

public class ListModel<T> extends Messager{
	public PagedResult<T> pr;

	public PagedResult<T> getPr() {
		return pr;
	}

	public void setPr(PagedResult<T> pr) {
		this.pr = pr;
	}
	
}
