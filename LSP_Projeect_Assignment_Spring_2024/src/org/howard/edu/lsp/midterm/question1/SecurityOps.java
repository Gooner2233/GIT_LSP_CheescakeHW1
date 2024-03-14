package org.howard.edu.lsp.midterm.question1;

public class SecurityOps {
    public static String encrypt(String text) {
        // Remove whitespace and punctuation characters
        String cleanText = text.replaceAll("[\\s\\p{Punct}]", "");

        StringBuilder encryptedText = new StringBuilder();

        // Iterate over the characters in the cleaned input text
        for (int i = 0; i < cleanText.length(); i++) {
            char ch = cleanText.charAt(i);

            // Even-indexed characters
            if (i % 2 == 0) {
                encryptedText.append(ch);
            }
        }

        // Append odd-indexed characters
        for (int i = 0; i < cleanText.length(); i++) {
            char ch = cleanText.charAt(i);

            // Odd-indexed characters
            if (i % 2 != 0) {
                encryptedText.append(ch);
            }
        }

        return encryptedText.toString();
    }
}