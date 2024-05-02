package org.howard.edu.lsp.oopfinal.question1;
import java.util.Set;

import org.howard.edu.lsp.oopfinal.question1.*;
public class Driver {

	public static void main(String[] args) {
		SongsDatabase db = new SongsDatabase();
		db.addSong("Rap", "Savage");
		db.addSong("Rap", "Gin and Juice");
		db.addSong("Country", "Sweet Alabama");
		db.addSong("Jazz", "Always There");

		Set<String> songs = db.getSongs("Rap");
		System.out.println(songs); //prints [Savage, Gin and Juice]
		System.out.println(db.getGenreOfSong("Savage"));// prints “Rap”
		System.out.println(db.getGenreOfSong("Always There"));// prints “Jazz”
		// All these tests run correctly : )
	}

}
