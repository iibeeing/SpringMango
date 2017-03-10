package com.mango.jtt.controller;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.mango.jtt.model.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class ProtobufControllerTest {
	 static RestTemplate restTemplate;  
	 String baseUri = "http://localhost:8080/SpringMango";  
	  
	 @Before  
	    public void setUp() throws Exception {  
	        restTemplate = new RestTemplate();  
	    }  
	 
	@Test
	public void testRead() {
		HttpHeaders headers = new HttpHeaders();
		RequestEntity<User> requestEntity = new RequestEntity<User>(headers, HttpMethod.POST,URI.create(baseUri + "/proto/read"));
		ResponseEntity<User> responseEntity = restTemplate.exchange(requestEntity, User.class);
		System.out.println(responseEntity.getBody());
	}

	@Test
	public void testWrite() {
		User user = User.newBuilder();
		user.setId(1);
		user.setName("zhangshan");
		HttpHeaders headers = new HttpHeaders();
		RequestEntity<User> requestEntity = new RequestEntity<User>(user, headers,HttpMethod.POST, URI.create(baseUri + "/proto/write"));
		ResponseEntity<User> responseEntity = restTemplate.exchange(requestEntity, User.class);
		System.out.println(responseEntity.getBody());
	}
}
