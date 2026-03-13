package com.example.eventreminder.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String event;
    private LocalDate date;
    private LocalTime time;

    @Column(length=1000)
    private String description;


    public Event(String event, LocalDate date, LocalTime time, String description) {
        this.event = event;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    // Getters setters
    public Long getID() {
        return id;
    }
    public String getEvent() {
        return event;
    }
    public LocalDate getDate() {
        return date;
    }
    public LocalTime getTIme() {
        return time;
    }
    public String getDescription() {
        return description;
    }

    public void setEvent(String event) {
        this.event = event;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
