package org.howard.edu.lsp.oopfinal.question3;

public class Client {
    public static void main(String[] args) {
        ShapeFactory Factory = new ShapeFactory();

        Shape rectangle = Factory.getShape("RECTANGLE");
        Shape circle = Factory.getShape("CIRCLE");
        circle.draw();
        rectangle.draw();
    }
}
