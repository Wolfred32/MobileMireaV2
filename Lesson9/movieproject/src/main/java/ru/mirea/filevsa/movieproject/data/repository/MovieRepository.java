package ru.mirea.filevsa.movieproject.data.repository;

import ru.mirea.filevsa.movieproject.domain.models.Movie;

public class MovieRepository {
    public boolean saveMovie(Movie movie){
        return true;
    }
    public Movie getMovie(){
        return new Movie(1,"Doctor Strange");
    }
}
