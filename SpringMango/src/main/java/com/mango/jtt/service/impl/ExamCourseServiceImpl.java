package com.mango.jtt.service.impl;

import java.util.List;

import org.junit.internal.ExactComparisonCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mango.jtt.dao.IExamCourseDao;
import com.mango.jtt.model.ExamCourse;
import com.mango.jtt.model.ExamCourseEditModel;
import com.mango.jtt.model.ExamCourseSearchModel;
import com.mango.jtt.service.IExamCourseService;

@Service("examCourseService")
public class ExamCourseServiceImpl implements IExamCourseService {
	@Autowired
	IExamCourseDao examCourseDao;

	public ExamCourse getObjectById(long id) throws Exception {
		ExamCourse model = examCourseDao.selectByPrimaryKey(id);
		// ExamCourseEditModel em = new ExamCourseEditModel();
		// em.setId(model.getId());
		// em.setName(model.getName());
		// Exam
		// em.setExamProject(model.getExamprojectid());
		// em.setDateTime(model.getDatetime());
		return model;
	}

	public List<ExamCourse> list(ExamCourseSearchModel searcher) throws Exception {
		ExamCourse record = new ExamCourse();
		/*
		 * record.setDatetime(searcher.getDateTime());
		 * record.setExamprojectid(searcher.getExamProject().getId());
		 * record.setId(searcher.getId()); record.setName(searcher.getName());
		 * record.setUserid(searcher.getUser().getId());
		 */
		return examCourseDao.select(record);
	}

	public Boolean save(ExamCourseEditModel model) throws Exception {
		Boolean result = false;
		ExamCourse ec = new ExamCourse(model);
		if (model.getId() == 0l) {
			examCourseDao.insertSelective(ec);
			result = true;
		}
		return result;
	}

	public Boolean update(ExamCourseEditModel model) throws Exception {
		Boolean result = false;
		ExamCourse ec = new ExamCourse(model);
		if (model.getId() > 0l) {
			examCourseDao.updateByPrimaryKeySelective(ec);
			result = true;
		}
		return result;
	}

	public Boolean delete(List<Long> ids) throws Exception {
		Boolean result = false;
		for (Long id : ids) {
			examCourseDao.deleteByPrimaryKey(id);
		}
		result = true;
		return result;
	}

}
