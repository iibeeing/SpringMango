package com.mango.jtt.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mango.jtt.model.User;

@RestController
public class ProtobufController {
	@RequestMapping("/proto/read")
	public ResponseEntity<User> protoRead() {
		return ResponseEntity.ok(User.newBuilder());
	}

	@RequestMapping("/proto/write")
	public ResponseEntity<User> protoRead(RequestEntity<User> requestEntity) {
		System.out.println("server===\n" + requestEntity.getBody());
		return ResponseEntity.ok(requestEntity.getBody());
	}
}
