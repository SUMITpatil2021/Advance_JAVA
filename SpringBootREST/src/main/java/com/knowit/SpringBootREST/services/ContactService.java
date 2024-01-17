package com.knowit.SpringBootREST.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowit.SpringBootREST.entities.Contact;
import com.knowit.SpringBootREST.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	ContactRepository crepo;
	
	public List<Contact> getall()
	{
		return crepo.findAll();
	}
	
}
