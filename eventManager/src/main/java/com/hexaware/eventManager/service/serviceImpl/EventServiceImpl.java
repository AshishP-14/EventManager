package com.hexaware.eventManager.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.eventManager.entity.Event;
import com.hexaware.eventManager.exception.EventNotFoundException;
import com.hexaware.eventManager.exception.NoDataFoundException;
import com.hexaware.eventManager.repository.EventRepository;
import com.hexaware.eventManager.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public List<Event> getAllEvents() throws NoDataFoundException {
		// TODO Auto-generated method stub
		List<Event> eventList = eventRepository.findAll();
		if(eventList.isEmpty()) {
			throw new NoDataFoundException("No Events found.");
		}
		return eventList;
	}

	@Override
	public Event getEventById(int id) throws EventNotFoundException {
		// TODO Auto-generated method stub
		Event eventList= eventRepository.findById(id)
				.orElseThrow(() -> new EventNotFoundException("EventId",id));
		return eventList;
	}

	@Override
	public Event createEvent(Event event) {
		// TODO Auto-generated method stub
		Event savedEvent = eventRepository.save(event);
		return savedEvent;
	}

	@Override
	public Event updateEvent(int id, Event updatedEvent) throws EventNotFoundException {
		// TODO Auto-generated method stub
		Event existingEvent = eventRepository.findById(id)
				.orElseThrow(() -> new EventNotFoundException("EventId",id));
		
		existingEvent.setTitle(updatedEvent.getTitle());
		existingEvent.setDescription(updatedEvent.getDescription());
		existingEvent.setLocation(updatedEvent.getLocation());
		existingEvent.setDate(updatedEvent.getDate());
		existingEvent.setMaxAttendees(updatedEvent.getMaxAttendees());
		existingEvent.setRegistrationFee(updatedEvent.getRegistrationFee());
		
		return eventRepository.save(existingEvent);
	}

	@Override
	public void deleteEvent(int id) throws EventNotFoundException {
		// TODO Auto-generated method stub
		if (!eventRepository.existsById(id)) {
            throw new EventNotFoundException("EventId",id);
        }
		eventRepository.deleteById(id);
	}

}
