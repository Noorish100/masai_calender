package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Event;

public interface EventDao extends JpaRepository<Event, Integer> {
	
	

}
