package com.mango.jtt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mango.jtt.dao.IUserTDao;
import com.mango.jtt.dao.impl.BaseDao;
import com.mango.jtt.model.ResponseResult;
import com.mango.jtt.model.User;
import com.mango.jtt.model.UserT;
import com.mango.jtt.service.IUserTService;
import com.mango.jtt.util.ConstUtil;

@Service
public class UserTServiceImpl implements IUserTService {
	@Autowired
	private IUserTDao userTDao;

	/*
	 * @Autowireds private BaseDao<UserT,Integer> baseDao;
	 */

	public UserT getUserTById(int userId) {
		return userTDao.selectByPrimaryKey(userId);
		// UserT u = baseDao.selectByPrimaryKey(Integer.valueOf(userId));
		// return u;
	}

	public List<UserT> selectAll() {
		// TODO Auto-generated method stub
		return userTDao.selectAll();
	}

	public ResponseResult saveOrUpdate(User model) throws Exception {
		// TODO Auto-generated method stub
		ResponseResult rr = new ResponseResult();
		UserT u = new UserT();
		u.setUserName(model.getName());
		u.setPassword(model.getPassword());
		int result = userTDao.insert(u);
		if (result == 1) {
			rr.setStatusCode(ConstUtil.RESPONSECODE_SUCCESS);
		} else {
			rr.setStatusCode(ConstUtil.RESPONSECODE_FAIL);
		}

		return rr;
	}

	public ResponseResult save(User model) throws Exception {
		ResponseResult rr = new ResponseResult();
		UserT u = new UserT();
		u.setUserName(model.getName());
		u.setPassword(model.getPassword());
		int result = userTDao.insert(u);
		if (result == 1) {
			rr.setStatusCode(ConstUtil.RESPONSECODE_SUCCESS);
		} else {
			rr.setStatusCode(ConstUtil.RESPONSECODE_FAIL);
		}

		return rr;
	}

}
