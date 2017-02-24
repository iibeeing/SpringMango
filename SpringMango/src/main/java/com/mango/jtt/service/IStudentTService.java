package com.mango.jtt.service;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mango.jtt.model.Student;
import com.mango.jtt.model.StudentEditModel;
import com.mango.jtt.model.StudentSearchModel;
import com.mango.jtt.model.StudentT;
import com.mango.jtt.model.StudentListModel;

@Service
public interface IStudentTService {
	public StudentT getObjectTById(int id);

	//public ResponseEntity<StudentListModel> list(StudentSearchModel searcher) throws Exception;
	
	public List<StudentT> list(StudentSearchModel searcher) throws Exception;

	public Boolean save(StudentEditModel model) throws Exception;

	public Boolean update(StudentEditModel model) throws Exception;

	public StudentEditModel get(Integer id) throws Exception;

	public Boolean delete(Integer id) throws Exception;
}
