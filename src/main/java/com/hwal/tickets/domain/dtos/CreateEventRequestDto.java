package com.hwal.tickets.domain.dtos;


import com.hwal.tickets.domain.entities.eventStatusEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequestDto {
    //dto (data transfer object) is used for the presentation layer, whereas the original is for the service layer

    @NotBlank(message = "Event name is required")
    private String name;

    private LocalDateTime start;
    private LocalDateTime end;

    @NotBlank(message = "Venue is required")
    private String venue;


    private LocalDateTime salesStart;
    private LocalDateTime salesEnd;

    @NotNull(message = "Event status is required")
    private eventStatusEnum status;

    @NotEmpty(message = "Atleast one ticket type is required")
    @Valid //activates the validation annotations I created for ticketTypeReq dto
    private List<CreateTicketTypeRequestDto> ticketTypes;

}
