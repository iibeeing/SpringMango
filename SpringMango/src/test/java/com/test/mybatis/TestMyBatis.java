package com.test.mybatis;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;  
import com.alibaba.fastjson.JSON;
import com.mango.jtt.model.UserT;
import com.mango.jtt.service.IUserTService;

@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	// private ApplicationContext ac = null;
	//@Autowired
	@SuppressWarnings("restriction")
	@Resource  
	private IUserTService userTService = null;

	// @Before
	// public void before() {
	// ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	// userService = (IUserService) ac.getBean("userService");
	// }

	@Test
	public void test1() {
		UserT user = userTService.getUserTById(1);
		// System.out.println(user.getUserName());
		// logger.info("值："+user.getUserName());
		System.out.println(user.toString());
		logger.info(JSON.toJSONString(user));
	}
}
