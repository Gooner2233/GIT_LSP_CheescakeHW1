package org.howard.edu.lsp.midterm.question2;

/**
 * Class for testing the IntegerRange class.
 */
public class RangeTester {
    public static void main(String[] args) {
        // Test the IntegerRange class
        Range range1 = new IntegerRange(1, 5);
        Range range2 = new IntegerRange(3, 7);
        
        System.out.println("Range 1 contains 3: " + range1.contains(3)); // true
        System.out.println("Range 2 contains 6: " + range2.contains(6)); // true
        
        System.out.println("Range 1 overlaps with Range 2: " + range1.overlaps(range2)); // true
        
        System.out.println("Size of Range 1: " + range1.size()); // 5
        System.out.println("Size of Range 2: " + range2.size()); // 5
        
        // Test equals method
        Range range3 = new IntegerRange(1, 5);
        System.out.println("Range 1 equals Range 3: " + range1.equals(range3)); // true
        
        // Extensive Edge Case Tests
        Range r1 = new IntegerRange(1, 5);
        Range r2 = new IntegerRange(1, 4);
        Range r3 = new IntegerRange(2, 5);
        Range r4 = new IntegerRange(1, 5);
        System.out.println("R1 equals R2: " + r1.equals(r2)); // false
        System.out.println("R1 equals R3: " + r1.equals(r3)); // false
        System.out.println("R1 equals R4: " + r1.equals(r4)); // true
        System.out.println("R2 contains 6: " + r2.contains(6)); // false
        System.out.println("R3 contains 1: " + r3.contains(1)); // false
        System.out.println("R1 contains 1: " + r1.contains(1)); // true
    }
}