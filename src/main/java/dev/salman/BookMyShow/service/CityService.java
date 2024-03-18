package dev.salman.BookMyShow.service;

import dev.salman.BookMyShow.exception.InvalidCityException;
import dev.salman.BookMyShow.model.City;
import dev.salman.BookMyShow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public City getCityById(int cityId){
        return cityRepository.findById(cityId).orElseThrow(()-> new InvalidCityException("Invalid City Id"));
    }

    public City getCityByName(String cityName){
        return cityRepository.findCityByName(cityName);
    }

    public City saveCity(String cityName){
        City city = new City();
        city.setName(cityName);
        return cityRepository.save(city);
    }

    public City saveCity(City city){
        return cityRepository.save(city);
    }

    public boolean deleteCityById(int cityId){
        cityRepository.deleteById(cityId);
        return true;
    }
}
