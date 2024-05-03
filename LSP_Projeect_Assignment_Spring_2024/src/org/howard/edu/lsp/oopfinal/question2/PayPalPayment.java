package org.howard.edu.lsp.oopfinal.question2;

public class PayPalPayment implements PaymentStrategy {
    private String emailAddress;

    public PayPalPayment(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void pay(double amount) {
    	//Pay printing sugar
        System.out.println("Paid " + amount + " using PayPal account " + emailAddress);
    }
}