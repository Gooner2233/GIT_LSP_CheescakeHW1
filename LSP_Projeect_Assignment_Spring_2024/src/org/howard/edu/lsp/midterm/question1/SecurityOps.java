package org.howard.edu.lsp.midterm.question1;

/**
 * Security class for SecurityOps (index-based encryption).
 */
public class SecurityOps {
    
    /**
     * Returns the encrypted message based on the even and odd placing of letters in the input text.
     *
     * @param text the text to be encrypted
     * @return the encrypted message
     */
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
