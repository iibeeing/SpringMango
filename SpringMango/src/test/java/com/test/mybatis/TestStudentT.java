package com.test.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mango.jtt.model.StudentT;
import com.mango.jtt.service.IStudentTService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestStudentT {

	@Autowired
	IStudentTService studentTService;

	@Test
	public void test() {
		StudentT s = studentTService.getObjectTById(2);
		System.out.println(s);
	}

}
