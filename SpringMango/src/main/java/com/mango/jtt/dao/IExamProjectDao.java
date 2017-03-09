package com.mango.jtt.dao;
import com.mango.jtt.model.ExamProject;

public interface IExamProjectDao {
    int deleteByPrimaryKey(Long id);

    int insert(ExamProject record);

    int insertSelective(ExamProject record);

    ExamProject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExamProject record);

    int updateByPrimaryKey(ExamProject record);
}