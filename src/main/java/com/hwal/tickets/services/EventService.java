package com.hwal.tickets.services;


import com.hwal.tickets.domain.CreateEventRequest;
import com.hwal.tickets.domain.UpdateEventRequest;
import com.hwal.tickets.domain.entities.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest event);


    //Page allows us to limit the amount of events retrieved (instead of retrieving a lot of events and overflowing page)
    Page<Event> listEventsForOrganizer(UUID organizerID, Pageable pageable);
    Optional<Event> getEventForOrganizer(UUID organizerId, UUID id);
    Event updateEventForOrganizer(UUID organizerId, UUID id, UpdateEventRequest event);
    void deleteEventForOrganizer(UUID organizerId, UUID id);
    Page<Event> listPublishedEvents(Pageable pageable);
}
