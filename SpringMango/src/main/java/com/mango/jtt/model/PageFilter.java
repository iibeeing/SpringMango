package com.mango.jtt.model;

public abstract class PageFilter {

	protected int pageIndex;
	protected int pageSize;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public boolean isPaging()
	{
		if(this.pageIndex > 0 && this.pageSize > 0) {
			return true;
		}
		return false;
	}
}
