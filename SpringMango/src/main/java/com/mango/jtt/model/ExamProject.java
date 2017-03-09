package com.mango.jtt.model;

import java.io.Serializable;
import java.util.Date;

public class ExamProject implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;

	private String name;

	private Integer userid;

	private Date datetime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}
