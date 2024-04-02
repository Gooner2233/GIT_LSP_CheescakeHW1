package org.howard.edu.lsp.assignment5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerSetTest {

    @Test
    @DisplayName("Test case for add method")
    public void testAdd() {
        IntegerSet set = new IntegerSet();

        // Test adding to an empty set
        set.add(1);
        assertTrue(set.contains(1));

        // Test adding duplicate elements
        set.add(1);
        assertEquals(1, set.length());

        // Test adding multiple elements
        set.add(2);
        set.add(3);
        assertEquals(3, set.length());
    }

    @Test
    @DisplayName("Test case for remove method")
    public void testRemove() {
        IntegerSet set = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));

        // Test removing an element present in the set
        set.remove(2);
        assertFalse(set.contains(2));
        assertEquals(2, set.length());

        // Test removing an element not present in the set
        set.remove(4);
        assertEquals(2, set.length());
    }
    
    @Test
    @DisplayName("Test case for compounding add and remove method")
    public void test() {
        IntegerSet set = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet temp = set;
        // Test removing an element present in the set
        set.remove(2);
        assertFalse(set.contains(2));
        assertEquals(2, set.length());

        // Test removing an element not present in the set
        set.remove(4);
        assertEquals(2, set.length());
        
        set.add(2);
        assertEquals(set, temp);
    }

    @Test
    @DisplayName("Test case for union method")
    public void testUnion() {
        IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet set2 = new IntegerSet(new ArrayList<>(Arrays.asList(3, 4, 5)));

        // Test union with an empty set
        set1.union(new IntegerSet());
        assertEquals(3, set1.length());

        // Test union with a non-empty set
        set1.union(set2);
        assertEquals(5, set1.length());
    }
    
    @Test
    @DisplayName("Test for empty set case for union method")
    public void testEmptyUnion() {
    	IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
	    // Test intersection with an empty set
    	IntegerSet temp = set1;
	    set1.intersect(new IntegerSet());
	    
	    //Should be unchanged
	    assertEquals(set1, temp);
    }
    
    @Test
    @DisplayName("Test case for compounding union to intersection methods")
    public void testCompoundUnion() {
    	IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet set2 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 3, 4, 5)));
        IntegerSet set3 = new IntegerSet(new ArrayList<>(Arrays.asList(6, 7)));
	    // Test intersection with an empty set
	    set1.union(set2);
	    assertEquals(5, set1.length());
	    
	    set1.union(set3);
	    for (int i = 1; i<8; i++){
	    	assertTrue(set1.contains(i));
	    }
	    
	    set1.intersect(set2);
	    assertTrue(set1.equals(set2));
    }
    
    @Test
    @DisplayName("Test case for repeated unions (Unchanged)")
    public void testRepeatedUnion() {
    	IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet set2 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 3, 4, 5)));
        
    	set1.union(set2);
    	
    	//Repeating this should not change set 1
        IntegerSet temp = set1;
	    set1.intersect(set2);
	    assertEquals(set1, temp);
    }

    @Test
    @DisplayName("Test case for intersect method")
    public void testIntersect() {
        IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        IntegerSet set2 = new IntegerSet(new ArrayList<>(Arrays.asList(3, 4, 5)));

        // Test intersection with a non-empty set
        set1.intersect(set2);

        assertEquals(2, set1.length());
        assertFalse(set1.contains(1));
        assertFalse(set1.contains(2));
        assertTrue(set1.contains(3));
        assertTrue(set1.contains(4));
        assertFalse(set1.contains(5)); 
    }
    
    @Test
    @DisplayName("Test for empty set case for intersect method")
    public void testEmptyIntersect() {
    	IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
	    // Test intersection with an empty set
	    set1.intersect(new IntegerSet());
	    assertTrue(set1.isEmpty());
    }
    
    @Test
    @DisplayName("Test case for compounding intersect to union methods")
    public void testCompoundIntersect() {
    	IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet set2 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 3, 4, 5)));
        IntegerSet set3 = new IntegerSet(new ArrayList<>(Arrays.asList(3)));
	    // Test intersection with an empty set
	    set1.intersect(set2);
	    assertEquals(2, set1.length());
	    assertTrue(set1.contains(1));
	    assertFalse(set1.contains(2));
	    assertTrue(set1.contains(3));
	    
	    set1.union(set2);
	    assertTrue(set1.equals(set2));
	    
	    set1.intersect(set2);
	    assertTrue(set1.contains(1));
	    assertFalse(set1.contains(2));
	    assertTrue(set1.contains(3));
    }
    
    @Test
    @DisplayName("Test case for repeated intersections (Unchanged)")
    public void testRepeatedIntersect() {
    	IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet set2 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 3, 4, 5)));
        
    	set1.intersect(set2);
    	
    	//Repeating this should not change set 1
        IntegerSet temp = set1;
	    set1.intersect(set2);
	    assertEquals(set1, temp);
    }

    @Test
    @DisplayName("Test case for difference method")
    public void testDiff() {
        IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        IntegerSet set2 = new IntegerSet(new ArrayList<>(Arrays.asList(3, 4, 5)));

        // Test difference with an empty set
        set1.diff(new IntegerSet());
        assertEquals(4, set1.length());

        // Test difference with a non-empty set
        set1.diff(set2);
        assertEquals(2, set1.length());
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
    }
    
    @Test
    @DisplayName("Test for empty set case for difference method")
    public void testEmptydiff() {
    	IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
	    // Test intersection with an empty set
    	IntegerSet temp = set1;
	    set1.diff(new IntegerSet());
	    assertTrue(set1.equals(temp));
    }
    
    @Test
    @DisplayName("Test case for compounding difference to union methods")
    public void testCompoundDifference() {
    	IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet set2 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 3, 4, 5)));

	    set1.diff(set2);
	    assertEquals(1, set1.length());
	    assertTrue(set1.contains(2));
	    
	    set1.union(set2);
	    for (int i = 1; i<5; i++){
	    	assertTrue(set1.contains(i));
	    }
	    
	    set1.diff(set2);
	    assertEquals(1, set1.length());
	    assertTrue(set1.contains(2));
    }
    
    @Test
    @DisplayName("Test case for compounding difference to intersection methods")
    public void testCompoundDifferenceIntersection() {
    	IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet set2 = new IntegerSet(new ArrayList<>(Arrays.asList(3, 4, 5)));

	    set1.diff(set2);
	    assertEquals(2, set1.length());
	    assertTrue(set1.contains(1));
	    assertTrue(set1.contains(2));
	    
	    set1.intersect(set2);
	    assertTrue(set1.isEmpty());
	    
	    set1.diff(set2);
	    assertTrue(set1.isEmpty());
    }
    
    @Test
    @DisplayName("Test case for repeated differences (Unchanged)")
    public void testRepeatedDifference() {
    	IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet set2 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 3, 4, 5)));
        
    	set1.diff(set2);
    	
    	//Repeating this should not change set 1
        IntegerSet temp = set1;
	    set1.intersect(set2);
	    assertEquals(set1, temp);
    }
    
    @Test
    @DisplayName("Test case for complement method (empty set)")
    public void testComplementEmptySet() {
        IntegerSet set = new IntegerSet();

        // Test complement of an empty set
        set.complement(new IntegerSet());
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Test case for complement method (non-empty set)")
    public void testComplementNonEmptySet() {
        IntegerSet set = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));

        // Test complement of a non-empty set
        set.complement(new IntegerSet());
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Test case for complement method (set with elements)")
    public void testComplementSetWithElements() {
        IntegerSet set = new IntegerSet(new ArrayList<>(Arrays.asList(1, 3, 5, 7)));

        // Test complement of a set with elements
        set.complement(new IntegerSet(new ArrayList<>(Arrays.asList(2, 4, 6))));
        assertEquals(3, set.length());
        assertTrue(set.contains(2));
        assertTrue(set.contains(4));
        assertTrue(set.contains(6));
    }
    
    @Test
    @DisplayName("Test case for combined operations")
    public void testCombinedOperations() {
        // Create two sets with some common elements
        IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        IntegerSet set2 = new IntegerSet(new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7)));
        IntegerSet temp = new IntegerSet(new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7)));

        // Take the complement of set1 and set2
        set1.complement(new IntegerSet());
        set2.complement(new IntegerSet());

        // Intersect set1 and set2
        set1.intersect(set2);
        assertTrue(set1.isEmpty()); // Expecting an empty set after intersection

        // Take the difference between set1 and set2
        set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        set1.diff(set2);
        
        assertEquals(5, set1.length());

        // Take the union of set1 and set2
        set2 = temp;

        set1.union(set2);
        
        assertEquals(7, set1.length()); // Expecting 7 elements in set1 after union
	    for (int i = 1; i<8; i++){
	    	assertTrue(set1.contains(i));
	    }
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertTrue(set1.contains(4));
        assertTrue(set1.contains(5));
        assertTrue(set1.contains(6));
        assertTrue(set1.contains(7));
    }
    
    @Test
    @DisplayName("Test case for clearing a set")
    public void testClear() {
    	IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet empt = new IntegerSet(new ArrayList<>(Arrays.asList()));
        
    	set1.clear();
    	
    	//check that set 1 has been cleared
	    assertEquals(set1, empt);
    }
    
    @Test
    @DisplayName("Test case for checking if a set is empty")
    public void testIsEmpty() {
    	IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet empt = new IntegerSet(new ArrayList<>(Arrays.asList()));
        
    	assertTrue(empt.isEmpty());
    	assertFalse(set1.isEmpty());
    }

    @Test
    @DisplayName("Test case for combining clear and isEmpty")
    public void testisEmpty() {
    	IntegerSet set1 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet empt = new IntegerSet(new ArrayList<>(Arrays.asList()));
        
        set1.clear();
    	
    	//check that set 1 has been cleared
	    assertEquals(set1, empt);
	    assertTrue(set1.isEmpty());
    }
    
    @Test
    @DisplayName("Test case for length method")
    public void testLength() {
        // Test length of an empty set
        IntegerSet set1 = new IntegerSet();
        assertEquals(0, set1.length());

        // Test length of a non-empty set
        IntegerSet set2 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals(5, set2.length());

        // Test length after adding elements
        set2.add(6);
        assertEquals(6, set2.length());

        // Test length after removing elements
        set2.remove(3);
        assertEquals(5, set2.length());
    }

    @Test
    @DisplayName("Test case for equals method")
    public void testEquals() {
        // Test equals with an empty set
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        assertTrue(set1.equals(set2));

        // Test equals with same elements in different order
        IntegerSet set3 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet set4 = new IntegerSet(new ArrayList<>(Arrays.asList(3, 2, 1)));
        assertTrue(set3.equals(set4));

        // Test equals with different elements
        IntegerSet set5 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet set6 = new IntegerSet(new ArrayList<>(Arrays.asList(4, 5, 6)));
        assertFalse(set5.equals(set6));

        // Test equals with same elements but different lengths
        IntegerSet set7 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3)));
        IntegerSet set8 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        assertFalse(set7.equals(set8));
    }

    @Test
    @DisplayName("Test case for contains method")
    public void testContains() {
        // Test contains with an empty set
        IntegerSet set1 = new IntegerSet();
        assertFalse(set1.contains(1));

        // Test contains with elements in the set
        IntegerSet set2 = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        assertTrue(set2.contains(3));

        // Test contains with elements not in the set
        assertFalse(set2.contains(6));

        // Test contains after removing an element
        set2.remove(3);
        assertFalse(set2.contains(3));
    }

    @Test
    @DisplayName("Test case for throwing exception largest method (empty set)")
    public void testLargestEmptySet() {
        IntegerSet set = new IntegerSet();

        // Test largest with an empty set (expecting IntegerSetException)
        assertThrows(IntegerSetException.class, () -> {
            set.largest();
        });
    }

    @Test
    @DisplayName("Test case for largest method (non-empty set)")
    public void testLargestNonEmptySet() throws IntegerSetException {
        // Test largest with a non-empty set
        IntegerSet set = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals(5, set.largest());

        // Test largest after removing elements
        set.remove(5);
        assertEquals(4, set.largest());
    }

    @Test
    @DisplayName("Test case for throwing exception smallest method (empty set)")
    public void testSmallestEmptySet() {
        IntegerSet set = new IntegerSet();

        // Test smallest with an empty set (expecting IntegerSetException)
        assertThrows(IntegerSetException.class, () -> {
            set.smallest();
        });
    }

    @Test
    @DisplayName("Test case for smallest method (non-empty set)")
    public void testSmallestNonEmptySet() throws IntegerSetException {
        // Test smallest with a non-empty set
        IntegerSet set = new IntegerSet(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals(1, set.smallest());

        // Test smallest after removing elements
        set.remove(1);
        assertEquals(2, set.smallest());
    }

}