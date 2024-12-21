package ru.mirea.filevsa.data.data.storage;


import ru.mirea.filevsa.data.data.storage.models.Movie;

public interface MovieStorage {
    public Movie get();
    public boolean save(Movie movie);
}
