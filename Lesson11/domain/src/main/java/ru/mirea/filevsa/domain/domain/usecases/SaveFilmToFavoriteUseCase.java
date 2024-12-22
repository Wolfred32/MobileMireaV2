package ru.mirea.filevsa.domain.domain.usecases;

import ru.mirea.filevsa.domain.domain.models.Movie;
import ru.mirea.filevsa.domain.domain.repository.MovieRepository;

public class SaveFilmToFavoriteUseCase {
    private MovieRepository movieRepository;
    public SaveFilmToFavoriteUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public boolean execute(Movie movie){
        return movieRepository.saveMovie(movie);
    }
}
