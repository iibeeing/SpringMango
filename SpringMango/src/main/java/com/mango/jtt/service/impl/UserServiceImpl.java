package com.mango.jtt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mango.jtt.dao.IUserDao;
import com.mango.jtt.model.Page;
import com.mango.jtt.model.ResponseResult;
import com.mango.jtt.model.TUser;
import com.mango.jtt.model.User;
import com.mango.jtt.service.IUserService;
import com.mango.jtt.util.ConstUtil;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao userDao;

	public ResponseResult list(User filter) throws Exception {
		ResponseResult rr = new ResponseResult();
		List<TUser> list = userDao.list(filter);
		List<User> ulist = new ArrayList<User>();
		Page<User> p = new Page<User>();
		for (TUser t : list) {
			User u = new User();
			u.setName(t.getName());
			u.setPassword(t.getPassword());
			ulist.add(u);
		}
		if (filter.isPaging()) {
			p.setPageIndex(filter.getPageIndex());
			p.setPageSize(filter.getPageSize());
		}
		p.setList(ulist);
		rr.setStatusCode(ConstUtil.RESPONSECODE_SUCCESS);
		rr.setResult(p);
		return rr;
	}

	public ResponseResult get(int id) throws Exception {
		// TODO Auto-generated method stub
		ResponseResult rr = new ResponseResult();
		User user = userDao.get(id);
		rr.setResult(user);
		rr.setStatusCode(ConstUtil.RESPONSECODE_SUCCESS);
		return rr;
	}

	public ResponseResult update(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseResult delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseResult saveOrUpdate(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseResult save(User model) throws Exception {
		//检查名称是否重复
		//如果不重复则新增保存
		ResponseResult rr = new ResponseResult();
		Boolean result = userDao.save(model);
		if(result){
			rr.setStatusCode(ConstUtil.RESPONSECODE_SUCCESS);
			rr.setResult(model);
		}else{
			rr.setStatusCode(ConstUtil.RESPONSECODE_FAIL);
		}
		return rr;
	}

}
