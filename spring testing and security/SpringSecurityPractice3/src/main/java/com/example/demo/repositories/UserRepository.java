package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u where uid = :uid and pwd =:pwd")
	public User getUser(String uid,String pwd);
	
	@Query("select u from User u where uid = :uid")
	public User getUser(String uid);
}
