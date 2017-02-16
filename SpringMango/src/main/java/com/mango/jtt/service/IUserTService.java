package com.mango.jtt.service;

import org.springframework.stereotype.Service;

import com.mango.jtt.model.UserT;

@Service
public interface IUserTService {
	public UserT getUserTById(int userId);
}
