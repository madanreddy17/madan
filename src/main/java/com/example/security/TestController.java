package com.example.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@PreAuthorize("hasRole('USER')")
	@GetMapping("hello")
	public String hello() {
		return "Hello Hi How are you?";
	}
	

	@PreAuthorize("hasRole('MANAGER')")
	@GetMapping("test1")
	public String test1() {
		return "Test1";
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("test2")
	public String test2() {
		return "Test2";
	}
}
