package com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Event;
import com.Exception.EventException;
import com.Repository.EventDao;

@Service
public class EventImpl implements EventServices {

	@Autowired
	private EventDao dao;

	@Override
	public Event updateEvent(Event event,Integer id) throws EventException {
		Optional<Event> optional = dao.findById(id);
		if (optional.isPresent()) {
			return dao.save(event);
		} else
			throw new EventException("Event not found");

	}

	@Override
	public Event deleteEvent(Integer event_id) throws EventException {
		Optional<Event> optional = dao.findById(event_id);
		if (optional.isPresent()) {
			Event event = optional.get();
			dao.delete(event);
			return event;
		} else
			throw new EventException("Event not exist");

	}

	@Override
	public Event createEvent(Event event) throws EventException {
		if (event == null) {
			throw new EventException("invalid event details");
		}
		return dao.save(event);
	}

	@Override
	public List<Event> getEventList() throws EventException {
		List<Event> events = dao.findAll();
		if (events.size() > 0)
			return events;
		else
			throw new EventException("events not found");
	}

}
