package com.mango.jtt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mango.jtt.dao.IStudentTDao;
import com.mango.jtt.model.StudentT;
import com.mango.jtt.service.IStudentTService;

@Service
public class StudentTServiceImpl implements IStudentTService {

	@Autowired
	IStudentTDao studentTDao;

	public StudentT getObjectTById(int id) {
		// TODO Auto-generated method stub
		return studentTDao.selectByPrimaryKey(id);
	}
	
	
}
