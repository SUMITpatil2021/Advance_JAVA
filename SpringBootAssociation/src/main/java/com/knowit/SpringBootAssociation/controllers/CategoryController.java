package com.knowit.SpringBootAssociation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.knowit.SpringBootAssociation.entities.Category;
import com.knowit.SpringBootAssociation.services.CategoryService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class CategoryController {

	@Autowired
	CategoryService cservice;
	
	@GetMapping("/getallcat")
	public List<Category>getAll()
	{
		return  cservice.getAll();
	}
	
	@GetMapping("/getonecat")
	public Category getOne(@RequestParam("cid")int cid)
	{
		return cservice.getone(cid);
	}
	
	@PostMapping("/savecat")
	public Category savecat(@RequestBody Category c)
	{
		return cservice.savecat(c);
		
	}
	
}
