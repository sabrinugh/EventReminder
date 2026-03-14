package com.example.eventreminder.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.eventreminder.model.Event;
import com.example.eventreminder.repo.EventRepo;

@Service
public class EventService {
    private final EventRepo repo;
    private final static Logger logger = Logger.getLogger(EventService.class.getName());

    public EventService (EventRepo repo) {
        this.repo = repo;
    }

    public Event saveEvent(Event event) {
        logger.info("Notif: Event saved to: " + event.getEventName());
        return repo.save(event);
    }

    public List<Event> getAllEvents() {
        return repo.findAll();
    }

    public List<Event> getEventByDate(LocalDate date) {
        return repo.findByDate(date);
    }

    public void deleteEvent(Long id) {
        repo.deleteById(id);
    }

    public Event updateEvent (Long id, Event updatedEvent) {
        Event event = repo.findById(id).orElseThrow();


        event.setEventName(updatedEvent.getEventName());
        event.setDate(updatedEvent.getDate());
        event.setTime(updatedEvent.getTime());
        event.setDescription(updatedEvent.getDescription());


        return repo.save(event);
    }

    @Scheduled(fixedRate = 60000) // Every minute, check for any events one day away
    public void checkEventReminders() {
        List<Event> events = repo.findByStatus("Pending...");

        LocalDateTime now = LocalDateTime.now();

        // Loop for all events currently not notified
        for (Event event : events) {
            LocalDateTime eventDateTime = LocalDateTime.of(event.getDate(), event.getTime());
            
            Long hoursUntilEvent = java.time.Duration.between(now, eventDateTime).toHours();

            if (hoursUntilEvent <= 24 && hoursUntilEvent > 23) {
                logger.info("Reminder: Event " + event.getEventName() + "due in 1 day at " + event.getTime());

                event.setStatus("Notified");
                repo.save(event);
            }
        }
    }

}
