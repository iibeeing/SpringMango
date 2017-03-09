package com.mango.jtt.dao;

import java.util.List;
import com.mango.jtt.model.ExamCourse;
import org.springframework.stereotype.Repository;
@Repository
public interface IExamCourseDao {
    int deleteByPrimaryKey(Long id);

    int insert(ExamCourse record);

    int insertSelective(ExamCourse record);

    ExamCourse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExamCourse record);

    int updateByPrimaryKey(ExamCourse record);
    
    List<ExamCourse> select(ExamCourse record);
}