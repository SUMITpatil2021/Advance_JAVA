package com.knowit.SpringBootAssociation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knowit.SpringBootAssociation.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
