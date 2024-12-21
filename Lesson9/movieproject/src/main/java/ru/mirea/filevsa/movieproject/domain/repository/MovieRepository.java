package ru.mirea.filevsa.movieproject.domain.repository;

import ru.mirea.filevsa.movieproject.domain.models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);
    public Movie getMovie();
}
