package ru.mirea.filevsa.movieproject.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ru.mirea.filevsa.data.data.MovieRepositoryImpl;
import ru.mirea.filevsa.data.data.storage.MovieStorage;
import ru.mirea.filevsa.data.data.storage.sharedprefs.SharedPrefMovieStorage;
import ru.mirea.filevsa.domain.domain.models.Movie;
import ru.mirea.filevsa.domain.domain.repository.MovieRepository;
import ru.mirea.filevsa.movieproject.R;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this, new ViewModelFactory(this)).get(MainViewModel.class);

        EditText text = findViewById(R.id.editTextMovie);
        TextView textView = findViewById(R.id.textViewMovie);

        viewModel.getFavoriteMovie().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(String.format("Save result: %s", s));
            }
        });

        findViewById(R.id.buttonSaveMovie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.setText(new Movie(2, text.getText().toString()));
            }
        });

        findViewById(R.id.buttonGetMovie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.getText();
            }
        });
    }


}