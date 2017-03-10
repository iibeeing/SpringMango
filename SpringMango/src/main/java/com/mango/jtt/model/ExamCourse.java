package com.mango.jtt.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 考试课程类
 * 
 * @author BEE
 *
 */
public class ExamCourse implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;

	private String name;

	private Long examprojectid;

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

	public Long getExamprojectid() {
		return examprojectid;
	}

	public void setExamprojectid(Long examprojectid) {
		this.examprojectid = examprojectid;
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

	public ExamCourse(ExamCourseEditModel model) {
		ExamCourse ec = new ExamCourse();
		ec.setDatetime(model.getDateTime());
		ec.setExamprojectid(model.getExamProject().getId());
		ec.setId(model.getId());
		ec.setName(model.getName());
	}

	public ExamCourse() {
	}
}
