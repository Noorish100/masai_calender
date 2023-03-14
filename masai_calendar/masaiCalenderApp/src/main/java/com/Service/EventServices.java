package com.Service;

import java.util.List;

import com.Entity.Event;
import com.Exception.EventException;

public interface EventServices {

    public Event updateEvent(Event event,Integer id) throws EventException;
	
	public Event deleteEvent(Integer event_id) throws EventException;
	
	public Event createEvent(Event event)throws EventException;
	
	public List<Event> getEventList() throws EventException;
}
