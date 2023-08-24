package MovieProject;

import java.util.ArrayList;

// This class will have the following instance variables:
// String name – the full name of the actor or actress.
// ArrayList<Movie> movies – an Arraylist that has movies that this actor has acted in.
// Add getters and setters for these instance variables.

// Make sure to create a constructor that initializes your variables appropriately.

public class Actor {

    private String name;
    private ArrayList<Movie> movies;

    public Actor() {
        this.movies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMovies(Movie movie) {
        this.movies.add(movie);
    }
    
    
}
