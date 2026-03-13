package com.example.eventreminder.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eventreminder.model.Event;


public interface EventRepo extends JpaRepository<Event, Long>{
    
}
