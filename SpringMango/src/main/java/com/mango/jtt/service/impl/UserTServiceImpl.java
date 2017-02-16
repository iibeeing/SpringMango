package com.mango.jtt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mango.jtt.dao.IUserTDao;
import com.mango.jtt.dao.impl.BaseDao;
import com.mango.jtt.model.UserT;
import com.mango.jtt.service.IUserTService;

@Service
public class UserTServiceImpl implements IUserTService {
	@Autowired
	private IUserTDao userTDao;
	
	/*@Autowired
	private BaseDao<UserT,Integer> baseDao;*/

	public UserT getUserTById(int userId) {
		return userTDao.selectByPrimaryKey(userId);
		//UserT u = baseDao.selectByPrimaryKey(Integer.valueOf(userId));
		//return u;
	}

}
