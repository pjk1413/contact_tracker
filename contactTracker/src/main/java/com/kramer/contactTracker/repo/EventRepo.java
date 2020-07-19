package com.kramer.contactTracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kramer.contactTracker.models.Event;

public interface EventRepo extends JpaRepository<Event, Long> {

}
