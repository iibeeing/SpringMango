package com.mango.jtt.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.mango.jtt.model.StudentT;

@Repository
public interface IStudentTDao {
	int deleteByPrimaryKey(Integer id);

	int insert(StudentT record);

	int insertSelective(StudentT record);

	StudentT selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(StudentT record);

	int updateByPrimaryKey(StudentT record);

	List<StudentT> select(StudentT record);
}