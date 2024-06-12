package com.hexaware.eventManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.eventManager.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

}
