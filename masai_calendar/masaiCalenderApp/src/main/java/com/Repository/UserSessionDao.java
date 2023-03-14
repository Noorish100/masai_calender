package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.CurrentUserSession;

public interface UserSessionDao extends JpaRepository<CurrentUserSession, Integer>{
	
	public CurrentUserSession findByUuid(String uuid);

}
