package ru.mirea.filevsa.domain.domain.repository;

import ru.mirea.filevsa.domain.domain.models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);
    public Movie getMovie();
}
