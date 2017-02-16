package com.mango.jtt.service;

import org.springframework.stereotype.Service;

import com.mango.jtt.model.StudentT;

@Service
public interface IStudentTService {
	public StudentT getObjectTById(int id);
}
