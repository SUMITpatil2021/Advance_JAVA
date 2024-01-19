package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.UserService;
import com.example.demo.entities.*;
import java.util.List;

@RestController
public class UserController {
	
	@Autowired
	UserService uservice;
	
	@GetMapping("/getAll")
	public List<User> getAll(){
		return uservice.getAll();
	}

}
