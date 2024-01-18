package com.knowit.SpringBootAssociation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.knowit.SpringBootAssociation.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
