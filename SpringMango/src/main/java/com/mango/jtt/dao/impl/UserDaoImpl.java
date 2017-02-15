package com.mango.jtt.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mango.jtt.dao.IUserDao;
import com.mango.jtt.model.TUser;
import com.mango.jtt.model.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {

	public List<TUser> list(User user) throws Exception {
		TUser u1 = new TUser();
		u1.setName("shunwukong");
		u1.setPassword("123");
		TUser u2 = new TUser();
		u2.setName("zhubajie");
		u2.setPassword("123");
		List<TUser> list = new ArrayList<TUser>();
		list.add(u1);
		list.add(u2);
		return list;
	}

	public User get(int id) throws Exception {
		User u1 = new User();
		u1.setName("shunwukong");
		u1.setPassword("123");
		u1.setId(id);
		return u1;
	}

	public Boolean save(User model) throws Exception {
		Boolean result = true;
		return result;
	}
}
