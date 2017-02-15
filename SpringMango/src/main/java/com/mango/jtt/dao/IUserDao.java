package com.mango.jtt.dao;

import java.util.List;

import com.mango.jtt.model.ResponseResult;
import com.mango.jtt.model.TUser;
import com.mango.jtt.model.User;

public interface IUserDao {
	public List<TUser> list(User user) throws Exception;

	public User get(int id) throws Exception;

	public Boolean save(User model) throws Exception;
}
