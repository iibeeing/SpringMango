package com.mango.jtt.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

public class ExamCourseEditModel {
	private long id;
	@NotBlank(message = "考试课程名称不能为空")
	private String name;
	@NotBlank(message = "考试名称不能为空")
	private ExamProject examProject;
	private Date dateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ExamProject getExamProject() {
		return examProject;
	}

	public void setExamProject(ExamProject examProject) {
		this.examProject = examProject;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

}
