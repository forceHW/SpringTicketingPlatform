package com.hwal.tickets.domain;


import com.hwal.tickets.domain.entities.User;
import com.hwal.tickets.domain.entities.eventStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequest {

    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private String venue;
    private LocalDateTime salesStart;
    private LocalDateTime salesEnd;
    private eventStatusEnum status;
//    private User organizer;

    private List<CreateTicketTypeRequest> ticketTypes = new ArrayList<>();



}
