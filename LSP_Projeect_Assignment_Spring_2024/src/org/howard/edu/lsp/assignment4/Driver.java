package org.howard.edu.lsp.assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {
    public static void main(String[] args) throws IntegerSetException {
        IntegerSet set1a = new IntegerSet();
        set1a.add(1);
        set1a.add(2);
        set1a.add(3);
        System.out.println("Set 1: " + set1a.toString()); // Expected: 123

        // Test constructor with initialized ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        IntegerSet set2a = new IntegerSet(list);
        System.out.println("Set 2: " + set2a.toString()); // Expected: 345

        // Test clear method
        set1a.clear();
        System.out.println("Set 1 after clear: " + set1a.toString()); // Expected: Empty

        // Test length method
        System.out.println("Length of Set 2: " + set2a.length()); // Expected: 3

        // Test equals method
        System.out.println("Set 1 equals Set 2: " + set1a.equals(set2a)); // Expected: false

        // Test contains method
        System.out.println("Set 2 contains 4: " + set2a.contains(4)); // Expected: true

        // Test largest method
        System.out.println("Largest element in Set 2: " + set2a.largest()); // Expected: 5

        // Test smallest method
        System.out.println("Smallest element in Set 2: " + set2a.smallest()); // Expected: 3

        // Test remove method
        set2a.remove(4);
        System.out.println("Set 2 after removing 4: " + set2a.toString()); // Expected: 35
    	
        // Test Case 1: Basic operations on set1
        System.out.println("\n****** Beginning new batch of TestingTest ******\n"
        		+ "Case 1:");
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.print("Set1: ");
        set1.toString();
        System.out.println("\nSmallest value in Set1: " + set1.smallest());
        System.out.println("Largest value in Set1: " + set1.largest());

        // Test Case 2: Basic operations on set2
        System.out.println("\nTest Case 2:");
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.print("Set2: ");
        set2.toString();

        // Test Case 3: Intersection of set1 and set2
        System.out.println("\nTest Case 3:");
        System.out.println("Intersection of Set1 and Set2");
        set1.intersect(set2);
        System.out.print("Result: ");
        set1.toString();

        // Test Case 4: Union of set1 and set2
        System.out.println("\nTest Case 4:");
        set1.clear(); // Clear set1 for union test
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.print("Set1: ");
        set1.toString();
        System.out.println("\nUnion of Set1 and Set2");
        set1.union(set2);
        System.out.print("Result: ");
        set1.toString();

        // Test Case 5: Difference of set1 and set2
        System.out.println("\nTest Case 5:");
        set1.clear(); // Clear set1 for difference test
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.print("Set1: ");
        set1.toString();
        System.out.println("\nDifference of Set1 and Set2");
        set1.diff(set2);
        System.out.println("Result: " + set1.toString());

        // Test Case 6: Complement of set1 with respect to set2
        System.out.println("\nTest Case 6:");
        set1.clear(); // Clear set1 for complement test
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.print("Set1: ");
        set1.toString();
        System.out.println("\nComplement of Set1 with respect to Set2");
        set1.complement(set2);
        System.out.println("Result: " + set1.toString());

        // Test Case 7: Testing equals method
        System.out.println("\nTest Case 7:");
        IntegerSet set3 = new IntegerSet();
        set3.add(1);
        set3.add(2);
        set3.add(3);
        System.out.print("Set1: ");
        set1.toString();
        System.out.println("\nSet3: " + set3.toString());
        System.out.print("Are Set1 and Set3 equal? " + set1.equals(set3));
        set1.remove(5);
        set1.toString();

    }
}
