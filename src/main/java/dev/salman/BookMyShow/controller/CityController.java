package dev.salman.BookMyShow.controller;

import dev.salman.BookMyShow.dto.CityRequestDto;
import dev.salman.BookMyShow.dto.CityResponseDto;
import dev.salman.BookMyShow.exception.InvalidCityException;
import dev.salman.BookMyShow.model.City;
import dev.salman.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/getCity/{name}")
    public ResponseEntity<CityResponseDto> getCityByName(@PathVariable("name") String cityName){
        try{
            if(cityName==null | cityName.isBlank() || cityName.isEmpty()){
                throw new InvalidCityException("City name cannot be null (or) empty (or) blank");
            }
            City city = cityService.getCityByName(cityName);
            CityResponseDto cityResponseDto = new CityResponseDto();
            cityResponseDto.setName(cityName);
            cityResponseDto.setTheatres(city.getTheatres());
            return ResponseEntity.ok(cityResponseDto);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/addCity")
    public ResponseEntity addCity(@RequestBody CityRequestDto cityRequestDto){
        try{
            String cityName = cityRequestDto.getName();
            if(cityName==null || cityName.isEmpty() || cityName.isBlank()){
                throw new InvalidCityException("City name cannot be null (or) empty (or) blank");
            }
            City savedCity = cityService.saveCity(cityName);
            CityResponseDto cityResponseDto = new CityResponseDto();
            cityResponseDto.setName(savedCity.getName());
            cityResponseDto.setTheatres(savedCity.getTheatres());
            return ResponseEntity.ok(cityResponseDto);
        }
        catch(InvalidCityException ce){
            ce.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/deleteCity/{id}")
    public ResponseEntity<Boolean> deleteCity(@PathVariable("id") int cityId){
        try{
            boolean result = cityService.deleteCityById(cityId);
            return ResponseEntity.ok(result);
        }
        catch (Exception e){
            return ResponseEntity.ok(false);
        }
    }
}
