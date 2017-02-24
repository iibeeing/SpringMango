package com.mango.jtt.model;

import com.mango.jtt.system.entity.Messager;
import com.mango.jtt.system.entity.PagedResult;

public class StudentListModel extends Messager{
	public PagedResult<StudentT> pr;

	public PagedResult<StudentT> getPr() {
		return pr;
	}

	public void setPr(PagedResult<StudentT> pr) {
		this.pr = pr;
	}
	
}
