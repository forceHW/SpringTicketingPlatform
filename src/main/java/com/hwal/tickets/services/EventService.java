package com.hwal.tickets.services;


import com.hwal.tickets.domain.CreateEventRequest;
import com.hwal.tickets.domain.entities.Event;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest event);


}
