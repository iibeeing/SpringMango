package com.mango.jtt.service;

import java.util.List;

import com.mango.jtt.model.ExamCourse;
import com.mango.jtt.model.ExamCourseSearchModel;

//@Service
public interface IExamCourseService {
	public ExamCourse getObjectById(long id) throws Exception;
	public List<ExamCourse> list(ExamCourseSearchModel searcher) throws Exception;
}
