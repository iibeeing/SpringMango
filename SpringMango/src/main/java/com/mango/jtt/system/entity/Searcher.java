package com.mango.jtt.system.entity;

public class Searcher {

	/*当前页号*/
	private Integer pageNo;
	/*每页记录数量*/
	private Integer pageSize;
	/*总的页数*/
	private Integer pageTotal;
	/*总的记录数*/
	private Integer recordTotal;
	
	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

	public Integer getRecordTotal() {
		return recordTotal;
	}

	public void setRecordTotal(Integer recordTotal) {
		this.recordTotal = recordTotal;
	}

}
