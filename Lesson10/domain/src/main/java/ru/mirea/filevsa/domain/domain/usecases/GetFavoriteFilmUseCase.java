package ru.mirea.filevsa.domain.domain.usecases;

import ru.mirea.filevsa.domain.domain.models.Movie;
import ru.mirea.filevsa.domain.domain.repository.MovieRepository;

public class GetFavoriteFilmUseCase {
    private MovieRepository movieRepository;
    public GetFavoriteFilmUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public Movie execute(){
        return movieRepository.getMovie();
    }
}
