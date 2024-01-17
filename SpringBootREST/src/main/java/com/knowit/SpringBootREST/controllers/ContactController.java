package com.knowit.SpringBootREST.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knowit.SpringBootREST.entities.Contact;
import com.knowit.SpringBootREST.services.ContactService;

@RestController
public class ContactController {

	@Autowired
	ContactService cservice;
	
	@GetMapping("/getall")
	public List<Contact> getAll()
	{
		return cservice.getall();
	}
	
}
