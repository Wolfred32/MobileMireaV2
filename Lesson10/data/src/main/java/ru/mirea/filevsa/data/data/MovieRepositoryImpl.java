package ru.mirea.filevsa.data.data;


import java.time.LocalDate;

import ru.mirea.filevsa.data.data.storage.models.Movie;
import ru.mirea.filevsa.data.data.storage.MovieStorage;
import ru.mirea.filevsa.domain.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {

    private MovieStorage movieStorage;

    public MovieRepositoryImpl(MovieStorage movieStorage) {
        this.movieStorage = movieStorage;
    }

    @Override
    public boolean saveMovie(ru.mirea.filevsa.domain.domain.models.Movie movie) {
        movieStorage.save(mapToStorage(movie));
        return true;
    }

    @Override
    public ru.mirea.filevsa.domain.domain.models.Movie getMovie() {
        return mapToDomain(movieStorage.get());
    }

    private Movie mapToStorage(ru.mirea.filevsa.domain.domain.models.Movie movie){
        String name = movie.getName();
        return new Movie(2, name, LocalDate.now().toString());
    }

    private ru.mirea.filevsa.domain.domain.models.Movie mapToDomain(Movie movie) {
        return new ru.mirea.filevsa.domain.domain.models.Movie(movie.getId(), movie.getName());
    }

}
