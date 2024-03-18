package dev.salman.BookMyShow.model;

import dev.salman.BookMyShow.model.constant.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String movieName;
    private String description;
    @ManyToMany
    private List<Actor> actors;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeature> movieFeatures;

    public Movie(){

    }

    public Movie(String movieName, String description) {
        this.movieName = movieName;
        this.description = description;
    }
}
