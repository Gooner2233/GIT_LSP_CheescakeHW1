package org.howard.edu.lsp.midterm.question1;
import org.howard.edu.lsp.midterm.question1.SecurityOps;

public class Driver {

    public static void main(String[] args) {
        String text = "I love CSCI363";
        // Call the encrypt method from the SecurityOps class
        String encryptedText = SecurityOps.encrypt(text);
        System.out.println("Encrypted Text: " + encryptedText);
    }
}
