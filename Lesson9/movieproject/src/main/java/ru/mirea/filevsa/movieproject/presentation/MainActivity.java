package ru.mirea.filevsa.movieproject.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.filevsa.movieproject.R;
import ru.mirea.filevsa.movieproject.data.MovieRepositoryImpl;
import ru.mirea.filevsa.movieproject.domain.repository.MovieRepository;
import ru.mirea.filevsa.movieproject.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.filevsa.movieproject.domain.usecases.SaveFilmToFavoriteUseCase;
import ru.mirea.filevsa.movieproject.domain.models.Movie;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText text = findViewById(R.id.editTextMovie);
        TextView textView = findViewById(R.id.textViewMovie);

        MovieRepository movieRepository = new MovieRepositoryImpl(getApplicationContext());
        findViewById(R.id.buttonSaveMovie).setOnClickListener((View view) -> {
            Boolean result = new SaveFilmToFavoriteUseCase(movieRepository).execute(new Movie(2, text.getText().toString()));
            textView.setText(String.format("Save result %s", result));
        });
        findViewById(R.id.buttonGetMovie).setOnClickListener((View view) -> {
            Movie moview = new GetFavoriteFilmUseCase(movieRepository).execute();
            textView.setText(String.format("Save result %s", moview.getName()));
        });
    }
}