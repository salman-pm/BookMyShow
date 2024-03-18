package dev.salman.BookMyShow.dto;

import dev.salman.BookMyShow.model.Theatre;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CityResponseDto {
    private String name;
    private List<Theatre> theatres;
}
