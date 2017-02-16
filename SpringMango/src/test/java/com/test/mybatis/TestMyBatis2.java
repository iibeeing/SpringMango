package com.test.mybatis;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.mango.jtt.model.UserT;
import com.mango.jtt.service.IUserTService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMyBatis2 {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	@SuppressWarnings("restriction")
	@Resource
	private IUserTService userTService = null;

	@Test
	public void test() {
		UserT user = userTService.getUserTById(1);
		System.out.println(user.toString());
		logger.info(JSON.toJSONString(user));
	}

}
