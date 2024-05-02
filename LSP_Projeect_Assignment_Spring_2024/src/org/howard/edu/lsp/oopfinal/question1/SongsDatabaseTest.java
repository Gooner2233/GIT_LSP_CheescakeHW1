package org.howard.edu.lsp.oopfinal.question1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SongsDatabaseTest {

    @Test
    @DisplayName("Standard Test Case 1")
    public void testAddSong() {
		SongsDatabase db = new SongsDatabase();
		db.addSong("Rap", "Savage");
		db.addSong("Rap", "Gin and Juice");
		db.addSong("Country", "Ghost riders in the Sky");
		db.addSong("Jazz", "Always There");

		Set<String> songs = db.getSongs("Rap");

        assertEquals(2, songs.size()); // Check the size of the set
        assertTrue(songs.contains("Savage")); // Check if the expected songs are present
        assertTrue(songs.contains("Gin and Juice"));

        assertEquals("Rap", db.getGenreOfSong("Savage")); // Check the genre of a song
        assertEquals("Country", db.getGenreOfSong("Ghost riders in the Sky"));
    }
    
    @Test
    @DisplayName("Add Song to New Genre Test")
    public void testAddSongToNewGenre() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Gospel", "How great is our God");

        Set<String> songs = db.getSongs("Gospel");
        assertEquals(1, songs.size());
        assertTrue(songs.contains("How great is our God"));
    }
    
    @Test
    @DisplayName("Add Song to Existing Genre Test")
    public void testAddSongToExistingGenre() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Gospel", "Amazing Grace");
        db.addSong("Gospel", "How great is our God");

        Set<String> songs = db.getSongs("Gospel");
        assertEquals(2, songs.size());
        assertTrue(songs.contains("How great is our God"));
    }
    
    @Test
    @DisplayName("Get Songs Test")
    public void testGetSongs() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Gospel", "How great is our God");
        db.addSong("Gospel", "Amazing Grace");

        Set<String> songs = db.getSongs("Gospel");
        assertEquals(2, songs.size());
        assertTrue(songs.contains("How great is our God"));
        assertTrue(songs.contains("Amazing Grace"));
    }
    
    @Test
    @DisplayName("Get Genre of Song Test")
    public void testGetGenreOfSong() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Gospel", "How great is our God");

        assertEquals("Gospel", db.getGenreOfSong("How great is our God"));
    }

    @Test
    @DisplayName("Get Songs from Non-Existent Genre Test")
    public void testGetSongsFromNonExistentGenre() {
        SongsDatabase db = new SongsDatabase();
        Set<String> songs = db.getSongs("Classical");
        assertNull(songs);
    }

    @Test
    @DisplayName("Add Multiple Songs Test")
    public void testAddMultipleSongs() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Gospel", "How great is our God");
        db.addSong("Rap", "Lose Yourself");
        db.addSong("Rock", "Stairway to Heaven");

        assertEquals(1, db.getSongs("Gospel").size());
        assertEquals(1, db.getSongs("Rap").size());
        assertEquals(1, db.getSongs("Rock").size());
    }

    @Test
    @DisplayName("Add Duplicate Song Test")
    public void testAddDuplicateSong() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Gospel", "How great is our God");
        db.addSong("Gospel", "How great is our God");

        assertEquals(1, db.getSongs("Gospel").size());
    }

}