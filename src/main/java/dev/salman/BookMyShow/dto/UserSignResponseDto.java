package dev.salman.BookMyShow.dto;

import dev.salman.BookMyShow.model.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserSignResponseDto {
    private int id;
    private List<Ticket> tickets;
    private ResponseStatus responseStatus;
}
