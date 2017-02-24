package com.mango.jtt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mango.jtt.dao.IStudentTDao;
import com.mango.jtt.model.StudentEditModel;
import com.mango.jtt.model.StudentSearchModel;
import com.mango.jtt.model.StudentT;
import com.mango.jtt.service.IStudentTService;

@Service
public class StudentTServiceImpl implements IStudentTService {

	@Autowired
	IStudentTDao studentTDao;

	public StudentT getObjectTById(int id) {
		return studentTDao.selectByPrimaryKey(id);
	}

	public Boolean save(StudentEditModel model) throws Exception {
		StudentT st = new StudentT();
		st.setAddress(model.getAddress());
		st.setFriendName(model.getFriendName());
		st.setName(model.getName());
		st.setWeight(model.getWeight());
		studentTDao.insert(st);
		return true;
	}

	public Boolean update(StudentEditModel model) throws Exception {
		StudentT st = new StudentT();
		st.setId(model.getId());
		st.setAddress(model.getAddress());
		st.setFriendName(model.getFriendName());
		st.setName(model.getName());
		st.setWeight(model.getWeight());
		studentTDao.updateByPrimaryKeySelective(st);
		return true;
	}

	public StudentEditModel get(Integer id) throws Exception {
		StudentEditModel model = null;
		StudentT st = this.getObjectTById(id);
		if(st != null){
			model = new StudentEditModel();
			model.setAddress(st.getAddress());
			model.setFriendName(st.getFriendName());
			model.setId(st.getId());
			model.setName(st.getName());
			model.setWeight(st.getWeight());
		}
		return model;
	}

	public Boolean delete(Integer id) throws Exception {
		Boolean result = false;
		int i = studentTDao.deleteByPrimaryKey(id);
		if(i > 0){
			result = true;
		}
		return result;
	}

	public List<StudentT> list(StudentSearchModel searcher) throws Exception {
		StudentT st = new StudentT();
		st.setAddress(searcher.getAddress());
		st.setFriendName(searcher.getFriendName());
		st.setName(searcher.getName());
		return studentTDao.select(st);
	}
	
	
}
