package ru.mirea.filevsa.movieproject.data;


import android.content.Context;
import android.content.SharedPreferences;


import ru.mirea.filevsa.movieproject.domain.repository.MovieRepository;
import ru.mirea.filevsa.movieproject.domain.models.Movie;

public class MovieRepositoryImpl implements MovieRepository {

    private final Context context;

    public MovieRepositoryImpl(Context context) {
        this.context = context;
    }

    @Override
    public boolean saveMovie(Movie movie){
        SharedPreferences sharedPref = context.getSharedPreferences("films_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("FAV_FILM", movie.getName());
        editor.apply();

        return true;
    }
    @Override
    public Movie getMovie(){
        SharedPreferences sharedPref = context.getSharedPreferences("films_data", Context.MODE_PRIVATE);
        String filmName = sharedPref.getString("FAV_FILM", "Game of throne");

        return new Movie(1, filmName);
    }
}
