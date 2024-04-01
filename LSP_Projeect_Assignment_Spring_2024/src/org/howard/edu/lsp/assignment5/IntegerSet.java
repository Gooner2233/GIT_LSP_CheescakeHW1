package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerSet {

	/**
	*  Store the set elements in an ArrayList
 	*/
	private List<Integer> set = new ArrayList<Integer>();

	/**
	*  Default Constructor
 	*/
	public IntegerSet() {
	}

	/**
	*  if you want to pass in already initialized
 	*/
	public IntegerSet(ArrayList<Integer> set) {
		this.set = set;
	}
	
	/**
	* Constructor for fetching the set
 	*/
	public List<Integer> getSet(){
		return this.set;
	}
	
 	/**
	* Clears the internal representation of the set
 	*/
	public void clear() {
		this.set.clear();
	};
	
 	/**
	* Returns the length of the set
 	*/
	public int length() {
		return this.set.size();
	};
	
	/**
	 * Returns true if the 2 sets are equal, false otherwise;
	 * Two sets are equal if they contain all of the same values in ANY order.  
	 * This overrides the equal method from the Object class.
	*/
	@Override
	public boolean equals(Object o) {
		
		// Is the object an instance of IntegerSet?
		if (!(o instanceof IntegerSet)) {
			return false;
		}
		
		//Cast the obj
		IntegerSet inputSet = (IntegerSet) o;
		if (inputSet.length() == this.set.size()) {
			if (inputSet.set.containsAll(this.set)) {
				return true;
			}
		}
		return false;
		
	}
	
	/**
	* Returns true if the set contains the value, otherwise false	
 	* @param value
 	*/
	public boolean contains(int value) {
		if (!this.set.contains(value)) {
			return false;
		} else {
			return true;
		}
	};    
	
	/**
	* Returns the largest item in the set; Throws a IntegerSetException if the set is empty
 	*/ 
	public int largest() throws IntegerSetException  {
            if (set.isEmpty()) {
                throw new IntegerSetException("You've got an empty set!");
            } else {
            double maxi = Double.NEGATIVE_INFINITY;
            for (int element : this.set) {
            	if (element>maxi){
            		maxi = element;
            	}
            }
            return (int) maxi;
	}
	};
	
	/**
	* Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
 	*/
	public int smallest() throws IntegerSetException {
		if (this.set.isEmpty()) {
			throw new IntegerSetException("Integer Set is Empty!");
		}
		return Collections.min(this.set);
	};
	
	/**
	* Adds an item to the set or does nothing it already there	
 	* @param item
 	*/
 	public void add(int item) {
 		if (!set.contains(item)) {
 			set.add(item);
 		}
 	};
	
 	/**
	* Removes an item from the set or does nothing if not there	
 	* @param item
 	*/
	public void remove(int item) {
		if(this.set.contains(item)) {
			this.set.remove(this.set.indexOf(item));
		}
	}; 
	
	/**
	* Performs union function with setb	
 	* @param item
 	*/
	public void union(IntegerSet intSetb) {
		for (int element: intSetb.set) {
			if (!this.set.contains(element)) {
				this.set.add(element);
			}
		}
	};
	/**
	* Performs intersect function with setb
    * @param intSetb
	*/
	public void intersect(IntegerSet intSetb) {
        List<Integer> notCommonIndexes = new ArrayList<>();

	    for (int i = 0; i < this.set.size(); i++) {
            if (!intSetb.set.contains(this.set.get(i))) {
               notCommonIndexes.add(i);
	        }
	    }

	    for (int j = notCommonIndexes.size() - 1; j >= 0; j--) {
	        set.remove((int) notCommonIndexes.get(j));
        }
	}
	
	/**
	* Performs difference function with setb	
 	* @param item
 	*/
	public void diff(IntegerSet intSetb) {
        List<Integer> commonIndexes = new ArrayList<>();

        for (int i = 0; i < this.set.size(); i++) {
            if (intSetb.set.contains(this.set.get(i))) {
                commonIndexes.add(i);
            }
        }

        for (int j = commonIndexes.size() - 1; j >= 0; j--) {
            set.remove((int) commonIndexes.get(j));
        }
	}
	
 	/**
	* Set complement, all elements not in s1
 	*/
	public void complement(IntegerSet intSetb) {
        List<Integer> notCommonelems = new ArrayList<>();

        for (int element: intSetb.set) {
            if (!this.set.contains(element)) {
            	notCommonelems.add(element);
            }
        }

        this.set.clear();
		for (int elem: notCommonelems) {
			if (!this.set.contains(elem)) {
				this.set.add(elem);
			}
		}
	}
	
 	/**
	* Returns true if the set is empty, false otherwise
 	*/
	boolean isEmpty() {
		return set.isEmpty();
	} 
	
	/**
	*  Return String representation of your set.
	*  This overrides the equal method from the Object class.
 	*/
	public String toString() {
		System.out.println(set.toString());
		return set.toString();
	};	// return String representation of your set
}