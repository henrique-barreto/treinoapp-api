package com.treinoapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	@RequestMapping(name = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> buscar(@RequestParam String username, @RequestParam String password) {

		System.out.println("username: " + username);
		System.out.println("password: " + password);

		ResponseEntity<String> responseEntity = new ResponseEntity<String>("zahsdkjashdkjsa", HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
}
