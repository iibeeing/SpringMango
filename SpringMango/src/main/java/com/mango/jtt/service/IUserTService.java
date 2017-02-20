package com.mango.jtt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mango.jtt.model.ResponseResult;
import com.mango.jtt.model.User;
import com.mango.jtt.model.UserT;

@Service
public interface IUserTService {
	public UserT getUserTById(int userId);

	public List<UserT> selectAll();

	public ResponseResult saveOrUpdate(User model) throws Exception;

	public ResponseResult save(User model) throws Exception;

	public ResponseResult login(UserT user) throws Exception;
}
