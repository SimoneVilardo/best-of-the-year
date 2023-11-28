package org.java.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.spring.pojo.Movie;
import org.java.spring.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class MainController {

	@GetMapping("/")
	public String test3(Model model) {
		
		
		final String name = "Simone";
		
		model.addAttribute("name", name);
		
		return "page1";
	}	
	
	
	@GetMapping("/movies")
    public String movies(Model model, String movies) {
        
        movies = "";
        
        for (Movie m : getBestMovies()) {
            
            if(m.getId() < getBestMovies().size()) {
                
                movies += m.getTitle() + ", ";
                
            } else {
                movies += m.getTitle();
            }
        }
        
        model.addAttribute("movies", movies);
        
        return "movies";
    }
    
    @GetMapping("/songs")
    public String songs(Model model, String songs) {
        
        songs = "";
        
        for (Song s : getBestSongs()) {
            
            if(s.getId() < getBestSongs().size()) {
                
                songs += s.getTitle() + ", ";
                
            } else {
                songs += s.getTitle();
            }
        }
        
        model.addAttribute("songs", songs);
        
        return "songs";
    }
    
    
    @GetMapping("/movies/{id}")
    public String showMovie(Model model, String movie, @PathVariable int id) {
		
    	for (Movie m : getBestMovies()) {
			
    		if(m.getId() == id) {
    			
    			movie = m.getTitle();
    			
    		}
    		
		}
    	
		model.addAttribute("id", id);
		model.addAttribute("movie", movie);
		
		return "show-movie";
    }
    
    
    @GetMapping("/songs/{id}")
    public String showSong(Model model, String song, @PathVariable int id) {
		
    	for (Song s : getBestSongs()) {
			
    		if(s.getId() == id) {
    			
    			song = s.getTitle();
    			
    		}
    		
		}
    	
		model.addAttribute("id", id);
		model.addAttribute("song", song);
		
		return "show-song";
    }
	
	private List<Movie> getBestMovies(){
        
        List<Movie> movies = new ArrayList<>();
        
        Movie m1 = new Movie(1, "The Shawshank Redemption");
        movies.add(m1);
        
        Movie m2 = new Movie(2, "The Godfather");
        movies.add(m2);
        
        Movie m3 = new Movie(3, "The Dark Knight");
        movies.add(m3);
        
        Movie m4 = new Movie(4, "Pulp Fiction");
        movies.add(m4);
        
        Movie m5 = new Movie(5, "Schindler's List");
        movies.add(m5);
        
        return movies;
    }
	
	
    private List<Song> getBestSongs(){
        
        List<Song> songs = new ArrayList<>();
        
        Song s1 = new Song(1, "Bohemian Rhapsody");
        songs.add(s1);
        
        Song s2 = new Song(2, "Like a Rolling Stone");
        songs.add(s2);
        
        Song s3 = new Song(3, "Imagine");
        songs.add(s3);
        
        Song s4 = new Song(4, "Billie Jean");
        songs.add(s4);
        
        Song s5 = new Song(5, "Hey Jude");
        songs.add(s5);
        
        return songs;
    }
	
	
}
