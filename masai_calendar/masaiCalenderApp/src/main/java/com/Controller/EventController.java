package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Event;
import com.Exception.EventException;
import com.Service.EventServices;

import jakarta.validation.Valid;

@RequestMapping("/masaiCalender")
@RestController
public class EventController {
	
	@Autowired
	private EventServices eventServices;
	
	
	@PutMapping("/event/{id}")
	public ResponseEntity<Event> update(@Valid @RequestBody Event event,@PathVariable("id") Integer event_id) throws EventException{
		Event e=eventServices.updateEvent(event, event_id);
		return new ResponseEntity<Event>(e,HttpStatus.OK);
	}
	

	@DeleteMapping("/event/{id}")
	public ResponseEntity<Event> delete(@Valid @PathVariable("id") Integer event_id) throws EventException{
		Event e=eventServices.deleteEvent(event_id);
		return new ResponseEntity<Event>(e,HttpStatus.OK);
	}
	

	@PostMapping("/event")
	public ResponseEntity<Event> create(@Valid @RequestBody Event event) throws EventException{
		Event e=eventServices.createEvent(event);
		return new ResponseEntity<Event>(e,HttpStatus.CREATED);
	}
	

	@GetMapping("/event")
	public ResponseEntity<List<Event>> getlist() throws EventException{
		List<Event> e=eventServices.getEventList();
		return new ResponseEntity<List<Event>>(e,HttpStatus.OK);
	}

}
