package com.example.eventreminder.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eventreminder.model.Event;


public interface EventRepo extends JpaRepository<Event, Long>{
    List<Event> findByDate(LocalDate date);
    List<Event> findByStatus(String status);
}
