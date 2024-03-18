package dev.salman.BookMyShow.controller;

import dev.salman.BookMyShow.dto.ResponseStatus;
import dev.salman.BookMyShow.dto.TheatreRequestDto;
import dev.salman.BookMyShow.dto.TheatreResponseDto;
import dev.salman.BookMyShow.exception.InvalidCityException;
import dev.salman.BookMyShow.exception.InvalidTheatreAddressException;
import dev.salman.BookMyShow.exception.InvalidTheatreNameException;
import dev.salman.BookMyShow.model.Theatre;
import dev.salman.BookMyShow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TheatreController {
    @Autowired
    private TheatreService theatreService;

    private void validateTheatreName(String theatreName){
        if(theatreName == null || theatreName.isEmpty() || theatreName.isBlank()){
            throw new InvalidTheatreNameException("Theatre name cannot be null/empty/blank");
        }
    }
    private void validateTheatreAddress(String address){
        if(address == null || address.isEmpty() || address.isBlank()){
            throw new InvalidTheatreAddressException("Theatre address cannot be null/empty/blank");
        }
    }

    @GetMapping("/getTheatre/{name}")
    public ResponseEntity<TheatreResponseDto> getTheatreByName(@PathVariable("name") String theatreName){
        TheatreResponseDto theatreResponseDto = new TheatreResponseDto();
        try{
            if(theatreName == null || theatreName.isBlank() || theatreName.isEmpty()){
                throw new InvalidTheatreNameException("Theatre name cannot be null/empty/blank");
            }
            Theatre theatre = theatreService.getTheatre(theatreName);
            theatreResponseDto.setTheatreName(theatre.getName());
            theatreResponseDto.setTheatreAddress(theatre.getAddress());
            theatreResponseDto.setAuditoriums(theatre.getAuditoriums());
            theatreResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return ResponseEntity.ok(theatreResponseDto);
        }
        catch (Exception e){
            theatreResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            return ResponseEntity.ok(theatreResponseDto);
        }
        //return null;
    }

    @PostMapping("/addTheatre")
    public ResponseEntity addTheatre(@RequestBody TheatreRequestDto theatreRequestDto){
        try{
            String theatreName = theatreRequestDto.getName();
            String theatreAddress = theatreRequestDto.getAddress();
            int cityId = theatreRequestDto.getCityId();
            //validate inputs
            validateTheatreName(theatreName);
            validateTheatreAddress(theatreAddress);
            if(cityId <= 0){
                throw new InvalidCityException("City Id should be greater than 0");
            }
            //save theatre
            Theatre theatre = theatreService.saveTheatre(theatreName, theatreAddress, cityId);
            //return Dto
            TheatreResponseDto theatreResponseDto = new TheatreResponseDto();
            theatreResponseDto.setTheatreName(theatre.getName());
            theatreResponseDto.setTheatreAddress(theatre.getAddress());
            theatreResponseDto.setAuditoriums(theatre.getAuditoriums());
            return ResponseEntity.ok(theatreResponseDto);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
