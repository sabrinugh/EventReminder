package com.example.eventreminder.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventreminder.model.Event;
import com.example.eventreminder.service.EventService;


@RestController
@RequestMapping("/events") // Check at hosted page /events
public class EventController {
    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return service.saveEvent(event);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return service.getAllEvents();
    }

    @GetMapping("/date/{date}")
    public List<Event> getEventByDate(@PathVariable LocalDate date) {
        return service.getEventByDate(date);
    }
}
