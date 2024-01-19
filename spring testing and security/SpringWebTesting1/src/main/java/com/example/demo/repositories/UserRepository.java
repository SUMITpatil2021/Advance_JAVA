package com.example.demo.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

@Repository
public interface UserRepository extends  JpaRepository<User, Integer> {
	/*private User [] users = {new User(1,"Bakul"),new User(3, "Milind"),new User(5, "Ragini")};
	
	public List<User> getAll()
	{
		return Arrays.asList(users);
	}*/
	
	//public 

}
