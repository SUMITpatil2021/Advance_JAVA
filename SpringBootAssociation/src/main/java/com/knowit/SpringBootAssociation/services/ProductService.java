package com.knowit.SpringBootAssociation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowit.SpringBootAssociation.entities.Product;
import com.knowit.SpringBootAssociation.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository prepo;
	
	public List<Product>getAll()
	{
		return prepo.findAll();
	}
	
	public Product getone(int  pid)
	{
		Product c=null;
		Optional<Product> op=prepo.findById(pid);
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
	
}
