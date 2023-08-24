package MovieProject;

import java.util.ArrayList;

// This class will have the following instance variables:
// String name – the name of the movie
// ArrayList<Actor> actors – an ArrayList of the actors in the movie. 
// double rating – a freshness rating from rotten tomatoes (www.rottentomatoes.com)
// Add getters and setters for these instance variables.

// Make sure to create a constructor that initializes your variables appropriately.

public class Movie {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    
    public Movie() {
		this.actors = new ArrayList<>();
	}


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Actor> getActors() {
        return actors;
    }


    public void setActors(Actor actor) {
        this.actors.add(actor);
    }


    public double getRating() {
        return rating;
    }


    public void setRating(double rating) {
        this.rating = rating;
    }

    

    
}
