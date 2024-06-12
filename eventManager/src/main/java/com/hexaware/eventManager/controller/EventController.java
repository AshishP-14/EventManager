package com.hexaware.eventManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.eventManager.entity.Event;
import com.hexaware.eventManager.exception.EventNotFoundException;
import com.hexaware.eventManager.exception.NoDataFoundException;
import com.hexaware.eventManager.service.EventService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/events")
@CrossOrigin("*")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Event>> searchAllEvents() throws NoDataFoundException{
		List<Event> eventList = eventService.getAllEvents();
		return ResponseEntity.ok(eventList);
	}
	@GetMapping("/getEvent/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable int id) throws EventNotFoundException {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@Valid @RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable int id, @Valid @RequestBody Event event) throws EventNotFoundException {
        Event updatedEvent = eventService.updateEvent(id, event);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable int id) throws EventNotFoundException {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
