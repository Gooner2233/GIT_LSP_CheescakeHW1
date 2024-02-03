package org.howard.edu.lsp.assignment2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileMain {

    public static String countWords(String words) {
        Map<String, Integer> wordDictionary = new LinkedHashMap<>();
        StringBuilder res = new StringBuilder();

        // Split the words by space and iterate through them
        String[] arr = words.split("\\s+");
        for (String word : arr) {
            // Check if the word contains at least one letter
            boolean clean = false;
            for (char character : word.toCharArray()) {
                if (Character.isLetter(character)) {
                    clean = true;
                    break;
                }
            }

            // If the word contains at least one letter and the first character is a letter
            if (clean && Character.isLetter(word.charAt(0))) {
            	String cleanedWord = word.toLowerCase();
	
	            // Update the Dictionary if the cleanedWord is significant
	            if (cleanedWord.length() > 3) {
	                wordDictionary.put(cleanedWord, wordDictionary.getOrDefault(cleanedWord, 0) + 1);
	            }
            }
        }

        // Build the resulting string
        for (Map.Entry<String, Integer> entry : wordDictionary.entrySet()) {
            res.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        return res.toString();
    }
	public static void main(String[] args) {
		String words = FileUtils.readTxtToString();
		String answ = countWords(words);
		System.out.println("Word count generated:");
		if (words!=null) {
			System.out.println(answ);
		} else {
			System.out.println("Failure :/");
		}

	}
}
