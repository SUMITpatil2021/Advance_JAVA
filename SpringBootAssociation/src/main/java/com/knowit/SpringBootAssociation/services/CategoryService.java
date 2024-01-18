package com.knowit.SpringBootAssociation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowit.SpringBootAssociation.entities.Category;
import com.knowit.SpringBootAssociation.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository crepo;
	
	public List<Category>getAll()
	{
		return crepo.findAll();
	}
	
	public Category getone(int cid)
	{
		Category c=null;
		Optional<Category>op=crepo.findById(cid);
		try
		{
			c=op.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return c;	
	}
	
	public Category savecat(Category c)
	{
		return crepo.save(c);
	}
}
