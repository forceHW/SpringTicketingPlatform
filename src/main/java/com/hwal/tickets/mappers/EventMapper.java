package com.hwal.tickets.mappers;


import com.hwal.tickets.domain.CreateEventRequest;
import com.hwal.tickets.domain.CreateTicketTypeRequest;
import com.hwal.tickets.domain.dtos.CreateEventRequestDto;
import com.hwal.tickets.domain.dtos.CreateEventResponseDto;
import com.hwal.tickets.domain.dtos.CreateTicketTypeRequestDto;
import com.hwal.tickets.domain.dtos.CreateTicketTypeResponseDto;
import com.hwal.tickets.domain.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);
}
