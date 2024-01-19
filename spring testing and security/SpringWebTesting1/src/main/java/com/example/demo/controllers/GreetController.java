package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.services.GreetingService;

@Controller
public class GreetController {
	
	@Autowired
	GreetingService grservice;
	
	@GetMapping("/greet")
	public @ResponseBody String greetUser()
	{
		return grservice.greet();
	}

}
