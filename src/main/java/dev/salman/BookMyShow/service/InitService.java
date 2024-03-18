package dev.salman.BookMyShow.service;

import dev.salman.BookMyShow.model.*;
import dev.salman.BookMyShow.model.constant.AuditoriumFeature;
import dev.salman.BookMyShow.model.constant.SeatStatus;
import dev.salman.BookMyShow.model.constant.SeatType;
import dev.salman.BookMyShow.model.constant.ShowSeatStatus;
import dev.salman.BookMyShow.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitService {
    private ActorRepository actorRepository;
    private AuditoriumRepository auditoriumRepository;
    private CityRepository cityRepository;
    private MovieRepository movieRepository;
    private PaymentRepository paymentRepository;
    private SeatRepository seatRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private TheatreRepository theatreRepository;
    private TicketRepository ticketRepository;
    private UserRepository userRepository;

    public boolean initialize(){
        City cbe = new City("Coimbatore");
        City hyderabad = new City("Hyderabad");
        City noida = new City("noida");
        cityRepository.save(cbe);
        cityRepository.save(hyderabad);
        cityRepository.save(noida);
        //get the saved city - because the saved city will have auto generated id
        City savedCbe = cityRepository.findCityByName("Coimbatore");

        Theatre inoxProzone = new Theatre("INOX_Prozone", "Prozone Mall, Saravampatty");
        Theatre cinepolisFun = new Theatre("Cinepolis_FunCinemas", "Fun Mall, Peelamedu");
        Theatre pvrBrookFields = new Theatre("PVR_BrookFields", "BrookFields Mall, Gandhipuram");
        //save theatres in theatre repository
        theatreRepository.save(inoxProzone);
        theatreRepository.save(cinepolisFun);
        theatreRepository.save(pvrBrookFields);
        //get the saved theatres() and add them to list - add the theatre list to city
        List<Theatre> theatreList = new ArrayList<>();
        theatreList.add(theatreRepository.findTheatreByName("INOX_Prozone"));
        theatreList.add(theatreRepository.findTheatreByName("Cinepolis_FunCinemas"));
        theatreList.add(theatreRepository.findTheatreByName("PVR_BrookFields"));
        //save the theatre list into city and save the city into repo
        savedCbe.setTheatres(theatreList);
        cityRepository.save(savedCbe);

        //create seats
        for(int i=1;i<=5;i++){
            Seat s = new Seat(i, i, i+ "-"+i, SeatType.GOLD, SeatStatus.AVAILABLE);
            seatRepository.save(s);
        }
        List<Seat> savedSeats = seatRepository.findAll(); //get all the seats from repo
        //create auditoriums
        Auditorium audi1 = new Auditorium();
        audi1.setName("Audi01");
        audi1.setCapacity(5);
        audi1.setAuditoriumFeatures(List.of(AuditoriumFeature.DOLBY, AuditoriumFeature.IMAX));
        audi1.setSeats(savedSeats);

        Auditorium audi2 = new Auditorium("Audi02",5);
        audi2.setAuditoriumFeatures(List.of(AuditoriumFeature.DOLBY));
        audi2.setSeats(savedSeats);

        Auditorium savedAudi1 = auditoriumRepository.save(audi1);
        Auditorium savedAudi2 = auditoriumRepository.save(audi2);

        List<Auditorium> auditoriumList = new ArrayList<>();
        auditoriumList.add(auditoriumRepository.findAuditoriumByName("Audi01"));
        auditoriumList.add(auditoriumRepository.findAuditoriumByName("Audi02"));

        Theatre savedInoxProzone = theatreRepository.findTheatreByName("INOX_Prozone");
        savedInoxProzone.setAuditoriums(auditoriumList);
        //save the theatre
        theatreRepository.save(savedInoxProzone);

        //create movies
        Movie kaithi = new Movie("Kaithi", "Action Thriller");
        Movie interstellar = new Movie("Interstellar", "Best movie");
        movieRepository.save(kaithi);
        movieRepository.save(interstellar);

        Show show1 = new Show();
        show1.setStartTime(LocalDateTime.now());
        show1.setEndTime(LocalDateTime.now().plusMinutes(180));
        show1.setMovie(movieRepository.findMovieByMovieName("Kaithi"));
        show1.setAuditorium(auditoriumRepository.findAuditoriumByName("Audi01"));

        Show show2 = new Show();
        show2.setStartTime(LocalDateTime.now());
        show2.setEndTime(LocalDateTime.now().plusMinutes(180));
        show2.setMovie(movieRepository.findMovieByMovieName("Interstellar"));
        show2.setAuditorium(auditoriumRepository.findAuditoriumByName("Audi02"));

        Show show3 = new Show();
        show3.setStartTime(LocalDateTime.now());
        show3.setEndTime(LocalDateTime.now().plusMinutes(180));
        show3.setMovie(movieRepository.findMovieByMovieName("Kaithi"));
        show3.setAuditorium(auditoriumRepository.findAuditoriumByName("Audi01"));

        Show show4 = new Show();
        show4.setStartTime(LocalDateTime.now());
        show4.setEndTime(LocalDateTime.now().plusMinutes(180));
        show4.setMovie(movieRepository.findMovieByMovieName("Interstellar"));
        show4.setAuditorium(auditoriumRepository.findAuditoriumByName("Audi02"));

        Show show5 = new Show();
        show5.setStartTime(LocalDateTime.now());
        show5.setEndTime(LocalDateTime.now().plusMinutes(180));
        show5.setMovie(movieRepository.findMovieByMovieName("Kaithi"));
        show5.setAuditorium(auditoriumRepository.findAuditoriumByName("Audi01"));

        showRepository.save(show1);
        showRepository.save(show2);
        showRepository.save(show3);
        showRepository.save(show4);
        showRepository.save(show5);

        for(int i=1;i<=5;i++){
            ShowSeat s = new ShowSeat(
                    250,
                    showRepository.findById(i).get(),
                    seatRepository.findSeatBySeatNumber(i+" "+i),
                    ShowSeatStatus.AVAILABLE
            );
            showSeatRepository.save(s);
        }

        return true;
    }
}
