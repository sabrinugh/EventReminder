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

    private String eventName;
    private LocalDate date;
    private LocalTime time;

    @Column(length=1000)
    private String description;

    private String status;


    public Event(String eventName, LocalDate date, LocalTime time, String description) {
        this.eventName = eventName;
        this.date = date;
        this.time = time;
        this.description = description;
        this.status = "Pending...";
    }

    // Getters setters
    public Long getID() {
        return id;
    }
    public String getEventName() {
        return eventName;
    }
    public LocalDate getDate() {
        return date;
    }
    public LocalTime getTime() {
        return time;
    }
    public String getDescription() {
        return description;
    }
    public String getStatus() {
        return status;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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
    public void setStatus(String status) {
        this.status = status;
    }

}
