package dev.salman.BookMyShow.service;

import dev.salman.BookMyShow.model.City;
import dev.salman.BookMyShow.model.Theatre;
import dev.salman.BookMyShow.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private CityService cityService;

    public Theatre getTheatre(String theatreName){
        return theatreRepository.findTheatreByName(theatreName);
    }

    public Theatre saveTheatre(String name, String address, int cityId){
        Theatre theatre = new Theatre();
        theatre.setName(name);
        theatre.setAddress(address);
        Theatre savedTheatre = theatreRepository.save(theatre);

        City city = cityService.getCityById(cityId);
        List<Theatre> theatres = city.getTheatres();
        theatres.add(theatre);
        city.setTheatres(theatres);
        cityService.saveCity(city);

        return savedTheatre;
    }
}
