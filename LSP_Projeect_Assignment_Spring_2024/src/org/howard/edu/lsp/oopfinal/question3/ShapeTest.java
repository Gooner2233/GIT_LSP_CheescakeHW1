package org.howard.edu.lsp.oopfinal.question3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ShapeTest {
    @Test
    public void testCircleDraw() {
        Circle circle = new Circle();
        assertNotNull(circle);
        circle.draw();
    }
    
    @Test
    public void testRectDraw() {
        Rectangle rectangle = new Rectangle();
        assertNotNull(rectangle);
        rectangle.draw();
    }
}
