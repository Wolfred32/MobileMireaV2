package ru.mirea.filevsa.movieproject.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.filevsa.movieproject.R;
import ru.mirea.filevsa.data.data.MovieRepositoryImpl;
import ru.mirea.filevsa.data.data.storage.MovieStorage;
import ru.mirea.filevsa.data.data.storage.sharedprefs.SharedPrefMovieStorage;
import ru.mirea.filevsa.domain.domain.repository.MovieRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText text = findViewById(R.id.editTextMovie);
        TextView textView = findViewById(R.id.textViewMovie);

        MovieStorage sharedPrefMovieStorage = new SharedPrefMovieStorage(this);
        MovieRepository movieRepository = (MovieRepository) new MovieRepositoryImpl(sharedPrefMovieStorage);
        findViewById(R.id.buttonSaveMovie).setOnClickListener((View view) -> {
            Boolean result = new
                    ru.mirea.filevsa.domain.domain.usecases.SaveFilmToFavoriteUseCase(movieRepository).execute(new ru.mirea.filevsa.domain.domain.models.Movie(2,
                    text.getText().toString()));
            textView.setText(String.format("Save result %s", result));
        });

        findViewById(R.id.buttonGetMovie).setOnClickListener((View view) -> {
            ru.mirea.filevsa.domain.domain.models.Movie moview = new ru.mirea.filevsa.domain.domain.usecases.GetFavoriteFilmUseCase(movieRepository).execute();
            textView.setText(String.format("Save result %s", moview.getName()));
        });
    }

}