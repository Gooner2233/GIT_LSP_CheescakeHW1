package org.howard.edu.lsp.assignment2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    public static String readTxtToString() {
        // relative path to the "words.txt" file
        String wordsPath = "\\src\\org\\howard\\edu\\lsp\\assignment2\\words.txt";

        // Get the cd and construct relative path
        String currentDirectory = System.getProperty("user.dir");
        Path filePath = Paths.get(currentDirectory, wordsPath);
        
        try {
            // Read the the file as a string
            String fileContents = new String(Files.readAllBytes(filePath));
            
            //Echo and return
            System.out.println("File we are reading:");
            System.out.print(fileContents);
            return fileContents;
        } catch (IOException e) {
            // Handle exceptions
            e.printStackTrace();
            return null;
        }
    }
}