package ru.mirea.filevsa.movieproject.presentation;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.mirea.filevsa.domain.domain.models.Movie;
import ru.mirea.filevsa.domain.domain.repository.MovieRepository;
import ru.mirea.filevsa.domain.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.filevsa.domain.domain.usecases.SaveFilmToFavoriteUseCase;

public class MainViewModel extends ViewModel {

    private MovieRepository movieRepository;

    private MutableLiveData<String> favoriteMovie = new MutableLiveData<>();

    public MutableLiveData<String> getFavoriteMovie() {
        return favoriteMovie;
    }

    public MainViewModel(MovieRepository movieRepository) {
        Log.d(MainViewModel.class.getSimpleName().toString(), "MainViewModel created");
        this.movieRepository = movieRepository;
    }

    @Override
    protected void onCleared() {
        Log.d(MainViewModel.class.getSimpleName().toString(), "MainViewModel cleared");
        super.onCleared();
    }

    public boolean setText(Movie movie){
        Boolean result = new SaveFilmToFavoriteUseCase(movieRepository).execute(movie);

        favoriteMovie.setValue(result.toString());
        return result;
    }
    public Movie getText(){
        Movie movie = new GetFavoriteFilmUseCase(movieRepository).execute();

        favoriteMovie.setValue(movie.getName());
        return movie;
    }

}
