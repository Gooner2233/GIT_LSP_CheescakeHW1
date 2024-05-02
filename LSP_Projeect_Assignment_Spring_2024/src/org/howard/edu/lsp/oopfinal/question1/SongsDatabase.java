package org.howard.edu.lsp.oopfinal.question1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SongsDatabase {
    private Map<String, Set<String>> map = 
    new HashMap<String, Set<String>>();
	
    /* Add a song title to a genre */
    public void addSong(String genre, String songTitle) {
        // Check if the genre already exists in the map
        if (!map.containsKey(genre)) {
            map.put(genre, new HashSet<>()); // Create a new HashSet for the genre
        }
        // Add the song title to the set corresponding to the genre
        map.get(genre).add(songTitle);
    }
	
	/* Return genre, i.e., jazz, given a song title */
	 public String getGenreOfSong(String songTitle) {
		    for (String genre : map.keySet()) {
		        if (map.get(genre).contains(songTitle)) {
		            return genre; // Return the genre when the song title is found
		        }
		    }
		    return null; // Return null if the song title is not found
		}
	
	 /* Return the Set that contains all songs for a genre */
	 public Set<String> getSongs(String genre) {
		 return map.get(genre);
	 }
}