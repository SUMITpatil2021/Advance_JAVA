package com.example.demo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	
	@GetMapping("/hello")	
	public String hello()
	{
		return "hello for guest user";
	}
	
	@GetMapping("/all")
	public String forAll() {
		return "request for all";		
	}
	
	@GetMapping("/user")
	public String forUser() {
		return "request for auser";		
	}
	
	@GetMapping("/admin")
	public String forAdmin() {
		return "request for admin";		
	}

}
