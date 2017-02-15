package com.mango.jtt.model;

import java.util.List;

public class Page<T> {
	private List<T> list;
	private int total;
	private int pageSize;
	private int pageIndex;
	
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalPage()
	{
		return (total + pageSize - 1) / pageSize;
	}
	
	public int getOffset(int pageIndex, int pageSize)
	{
		return pageSize * (pageIndex -1);
	}
	
	public int getFirstPageIndex()
	{
		return 1;
	}
	
	public int getLastPageIndex()
	{
		return getTotalPage();
	}
	
	public int getPrevPage()
	{
		if(pageIndex <= 1) {
			return 1;
		}
		return pageIndex - 1;
	}
	
	
}
