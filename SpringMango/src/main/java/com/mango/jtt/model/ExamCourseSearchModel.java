package com.mango.jtt.model;

import java.util.Date;

public class ExamCourseSearchModel {
	private long id;
	private String name;
	private ExamProject examProject;
	/* fuzeren */
	private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
