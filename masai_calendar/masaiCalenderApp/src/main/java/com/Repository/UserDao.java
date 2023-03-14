package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
public List<User> findByFirstName(String username);
	
	public User findByEmailId(String email);
}
