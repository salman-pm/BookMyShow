package dev.salman.BookMyShow.dto;

import dev.salman.BookMyShow.model.Auditorium;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TheatreResponseDto {
    private String theatreName;
    private String theatreAddress;
    @OneToMany
    private List<Auditorium> auditoriums;
    private ResponseStatus responseStatus;
}
