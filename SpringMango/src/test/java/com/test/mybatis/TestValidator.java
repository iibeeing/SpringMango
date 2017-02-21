package com.test.mybatis;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mango.jtt.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestValidator {

	private static ValidatorFactory factory = Validation
			.buildDefaultValidatorFactory();

	@Test
	public void test() {
		try {
			Student xiaoming = new Student();
			xiaoming.setName(null);
			xiaoming.setAddress("北京");
			xiaoming.setBirthday(new Date());
			xiaoming.setFriendName(null);
			xiaoming.setWeight(new BigDecimal(30));
			xiaoming.setEmail("xiaogangfan163.com");

			List<String> validate = validate(xiaoming);
			for (String s : validate) {
				System.out.println(s.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static <T> List<String> validate(T t) {
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

		List<String> messageList = new ArrayList<String>();
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			messageList.add(constraintViolation.getMessage());
		}
		return messageList;
	}

}
