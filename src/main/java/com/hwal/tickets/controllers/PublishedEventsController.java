package com.hwal.tickets.controllers;


import com.hwal.tickets.domain.dtos.GetPublishedEventDetailsResponseDto;
import com.hwal.tickets.domain.dtos.ListEventResponseDto;
import com.hwal.tickets.domain.dtos.ListPublishedEventsResponseDto;
import com.hwal.tickets.domain.entities.Event;
import com.hwal.tickets.mappers.EventMapper;
import com.hwal.tickets.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/published-events")
@RequiredArgsConstructor
public class PublishedEventsController {

    private final EventMapper eventMapper;
    private final EventService eventService;

    @GetMapping
    public ResponseEntity<Page<ListPublishedEventsResponseDto>> listEvents(
            @RequestParam(required = false) String q,
            Pageable pageable) {


        Page<Event> events;
        if(null != q && !q.trim().isEmpty()) {
            events = eventService.searchPublishedEvents(q, pageable);
        }
        else {
            events = eventService.listPublishedEvents(pageable);
        }

        return ResponseEntity.ok(events.map(eventMapper::toListPublishedEventsResponseDto));
    }


    @GetMapping(path = "/{eventId}")
    public ResponseEntity<GetPublishedEventDetailsResponseDto> getPublishedEvent(@PathVariable UUID eventId){
        return eventService.getPublishedEventForAttendee(eventId)
                .map(eventMapper::toGetPublishedEventDetailsResponseDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
