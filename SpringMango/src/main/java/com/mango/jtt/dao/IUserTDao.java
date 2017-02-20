package com.mango.jtt.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mango.jtt.model.UserT;

@Repository
public interface IUserTDao {
	int deleteByPrimaryKey(Integer id);

	int insert(UserT record);

	int insertSelective(UserT record);

	UserT selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(UserT record);

	int updateByPrimaryKey(UserT record);

	List<UserT> selectAll();
	
	List<UserT> select(UserT user) throws Exception;
}