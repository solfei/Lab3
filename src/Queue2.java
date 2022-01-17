
/**
 * Queue class - Two Stack Version
 * @author 
 * @author
 * CIS 22C, Lab 3
 */

import java.util.NoSuchElementException;

public class Queue2<T extends Comparable<T>> implements Q<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    /**** CONSTRUCTORS ****/

    /**
     * Default constructor for the Queue class 
     */
    public Queue() {

    }

    /**
     * Converts an array into a Queue  
     * @param array the array to copy into the
     * array
     */
    public Queue(T[] array) {
    
    }

    /**
     * Copy constructor for the Queue class
     * @param original the Queue to copy
     * @postcondition a new Queue object which is an identical, 
     * but distinct, copy of original
     */
    public Queue(Queue<T> original) {

    }

    /**** ACCESSORS ****/

    // Add methods here

    /**** MUTATORS ****/

    // Add methods here

    /**** ADDITONAL OPERATIONS ****/

    /**
     * Returns the values stored in the Queue as a String, separated by a blank
     * space with a new line character at the end
     * 
     * @return a String of Queue values
     */
    @Override
    public String toString() {
        return null;
    }

    /**
     * Determines whether two Queues contain the same values in the same order
     * 
     * @param o the Object to compare to this
     * @return whether o and this are equal
     */
    @Override
    public boolean equals(Object o) {
        return false;
    }

}
