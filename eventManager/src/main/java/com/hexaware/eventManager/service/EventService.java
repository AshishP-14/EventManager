package com.hexaware.eventManager.service;

import java.util.List;

import com.hexaware.eventManager.entity.Event;
import com.hexaware.eventManager.exception.EventNotFoundException;
import com.hexaware.eventManager.exception.NoDataFoundException;

public interface EventService {
	List<Event> getAllEvents() throws NoDataFoundException;

	Event getEventById(int id) throws EventNotFoundException;

	Event createEvent(Event event);

	Event updateEvent(int id, Event updatedEvent) throws EventNotFoundException;

	void deleteEvent(int id) throws EventNotFoundException;
}
