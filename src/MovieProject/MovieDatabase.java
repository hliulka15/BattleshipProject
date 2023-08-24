package MovieProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// This class has two instance variables:
// ArrayList<Movie> movieList – an ArrayList of movies
// ArrayList<Actor> actorList – an ArrayList of actors

// Note: Make sure to add getters for both these instance variables. That is, add a getMovieList() and a getActorList() method.

public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;
    private static String COMMA_DELIMITER = ",";

    public MovieDatabase() {
        this.movieList = new ArrayList<>();
        this.actorList = new ArrayList<>();
    }
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }
    public ArrayList<Actor> getActorList() {
        return actorList;
    }

    void addMovie(String name, String[] actors){

        // This method takes in the name of a movie that is not currently in the database along with a list of actors for that movie. 
        // If the movie is already in the database, your code ignores this request (this specification is an oversimplification). 
        // If the movie is a new movie, a movie object is created and added to the movieList. 
        // If any of the actors happen to be new, they will be added to the actorList.

        name = name.trim();

        Movie m = new Movie();
        m.setName(name);

        for(int i=0; i < actors.length; i++) {
			Actor temp = new Actor();
			temp.setName(actors[i]);
			m.setActors(temp);
		}

        if(movieList.size() != 0) {
			int i=0;
			while((i < movieList.size()) && ((movieList.get(i).getName().equals(name) == false))) {
				i++;
			}
			if(i == movieList.size()) {
				movieList.add(m);
			}
		} else {
			movieList.add(m);
		}

        // add movie to existing actors movie object
		if (actorList.size()> 0) {
			int i = 0;
			while(i < actorList.size()) {
				for (String element : actors) {
				    if ((element == actorList.get(i).getName())) {
				        actorList.get(i).setMovies(m);
				    }
				}
				i++;
			}
		}

        // add actors to actor list if not on actor list
		for(int i=0; i < actors.length; i++) {
			Actor temp = new Actor();
			temp.setName(actors[i].trim());
			temp.setMovies(m);
			if(actorList.size() > 0) {
				int j=0;
				while((j < actorList.size()) && (actorList.get(j).getName() != actors[i])) {
					j++;
				}
				if(j == actorList.size()) {
					actorList.add(temp);
				}
			} else {
				actorList.add(temp);
			}
		} 
        // add actors to existing movie object
		for(int i=0; i < actors.length; i++) {
			Actor temp = new Actor();
			temp.setName(actors[i].trim());
			temp.setMovies(m);
			for(int l=0; l < movieList.size(); l++) {
				if (movieList.get(l).getName().equals(name) && !movieList.get(l).getActors().get(0).getName().equals(actors[i].trim())){
					movieList.get(l).setActors(temp);
				}
			}
		}
    }

    void addRating(String name, double rating){

        // Add a rating for this movie. Assume that the name argument will definitely be a name that is currently in the database.
        for(Movie movie : movieList) {
			if (movie.getName().equals(name)) {
				movie.setRating(rating);
			}
			for(Actor actor : actorList) {
				for(int i = 0; i < actor.getMovies().size(); i++) {
					if(actor.getMovies().get(i).getName().equals(name)) {
						actor.getMovies().get(i).setRating(rating);
					}
				}
			}
		}

    }

    void updateRating(String name, double newRating){

        // Overwrite the current rating of a movie with this new rating. Again, assume that the name argument will definitely be a name that is currently in the database.
        for(Movie movie : movieList) {
			if (movie.getName().equals(name)) {
				movie.setRating(newRating);
			}
		}	

    }

    String getBestActor(){

        // Returns the name of the actor that has the best average rating for their movies.
        // In the case of a tie, return any one of the best actors.
        Actor topActor = new Actor();
		double highestRating = 0;
		for(Actor actor : actorList) {
			double ratingTotal = 0;
			int totalMovies = actor.getMovies().size();
			for(int i=0; i < totalMovies; i++) {
				ratingTotal += actor.getMovies().get(i).getRating();
			}
			double averageRating = ratingTotal / totalMovies;
			if (averageRating > highestRating) {
				highestRating = averageRating;
				topActor = actor;
			}
		}
		return topActor.getName();

    }

    String getBestMovie(){

        // Returns the name of the movie with the highest rating.
        // In the case of a tie, return any one of the best movies.
        Movie topMovie = new Movie();
		for(Movie movie : movieList) {
			if (movie.getRating() > topMovie.getRating()) {
				topMovie = movie;
			}
		}
		
		return topMovie.getName();
        
    }

    //     Main method
    // Finally, write a main method where:

        // You create a new instance of a movieDatabase.

        // Add all the movies in the file movies.txt.

        // Go through the ratings of the movies in the file ratings.txt and add the ratings for the movies.

        // Now call the methods that you created and print out the name of the best actor and the name of the highest rated movie.
    public static void main(String[] args) {
        MovieDatabase db = new MovieDatabase();

		// parse movies.csv and break into actor/movie pairs
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/MovieProject/movies.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(COMMA_DELIMITER);
		        records.add(Arrays.asList(values));
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// add all movies to database
		for(int i=0; i < records.size(); i++) {
			List<String> actorLine = records.get(i);
			String[] movieSet = new String[actorLine.size()];
			for(int j=1;  j<movieSet.length; j++) {
				db.addMovie(actorLine.get(j), new String[] {actorLine.get(0)});
			}
		}

        // parse ratings.csv and break into actor/movie pairs
		List<List<String>> ratings = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/MovieProject/ratings.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(COMMA_DELIMITER);
		        ratings.add(Arrays.asList(values));
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}

        // add ratings to movies in the database
        for(int i=0; i<ratings.size(); i++) {
            List<String> movieLine = ratings.get(i);
			db.addRating(movieLine.get(0), Double.parseDouble(movieLine.get(1)));
        }

        System.out.println("The best actor is " + db.getBestActor());
		System.out.println("The best movie is " + db.getBestMovie());
        
    }
    
}
