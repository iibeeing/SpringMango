package com.mango.jtt.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mango.jtt.model.ResponseResult;
import com.mango.jtt.model.User;
import com.mango.jtt.model.Users;

@Service
public interface IUserService {

	public ResponseResult list(User user) throws Exception;

	public ResponseResult get(int id) throws Exception;

	public ResponseResult update(User user) throws Exception;

	public ResponseResult delete(int id) throws Exception;

	public ResponseResult saveOrUpdate(User user) throws Exception;

	public ResponseResult save(User model) throws Exception;
	
//	public ResponseEntity<Users> lists(User user) throws Exception;
	
}
