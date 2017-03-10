package com.mango.jtt.service.impl;

import java.util.List;
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
		return examCourseDao.selectByPrimaryKey(id);
	}

	public List<ExamCourse> list(ExamCourseSearchModel searcher) throws Exception {
		ExamCourse record = new ExamCourse();
/*		record.setDatetime(searcher.getDateTime());
		record.setExamprojectid(searcher.getExamProject().getId());
		record.setId(searcher.getId());
		record.setName(searcher.getName());
		record.setUserid(searcher.getUser().getId());*/
		return examCourseDao.select(record);
	}

	@Override
	public Boolean save(ExamCourseEditModel model) throws Exception {
		Boolean result = false;
		ExamCourse ec = new ExamCourse(model);
		if(model.getId() != 0l){
			//更新
			examCourseDao.insertSelective(ec);
		}else{
			examCourseDao.updateByPrimaryKeySelective(ec);
		}
		result = true;
		return result;
	}

}
