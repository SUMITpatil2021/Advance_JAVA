package com.knowit.SpringBootREST.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knowit.SpringBootREST.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer>{

}
