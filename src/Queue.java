
/**
 * Queue class - singly-linked list version
 * @author
 * @author
 * CIS 22C, Lab 3
 */

import java.util.NoSuchElementException;

public class Queue<T> implements Q<T> {
    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node end;
    private int size;

    /**
     * Default constructor for the Queue class
     */
    public Queue() {

    }

    /**
     * Converts an array into a Queue
     * 
     * @param array the array to copy into
     *              the Queue
     */
    public Queue(T[] array) {

    }

    /**
     * Copy constructor for the Queue class
     * Makes a deep copy of the parameter
     * 
     * @param aQueue another Queue to copy
     */
    public Queue(Queue<T> aQueue) {

    }

    /**** ACCESSORS ****/

    // add methods here

    /**** MUTATORS ****/

    // add methods here

    /**** ADDITONAL OPERATIONS ****/

    /**
     * Returns the values stored in the Queue
     * as a String, separated by a blank space
     * with a new line character at the end
     * 
     * @return a String of Queue values
     */
    @Override
    public String toString() {
        return null;
    }

    /**
     * Determines whether two Queues contain
     * the same values in the same order
     * 
     * @param o the Object to compare to this
     * @return whether o and this are equal
     */
    @Override
    public boolean equals(Object o) {
        return false;
    }

    /** RECURSIVE HELPER METHODS */

    /**
     * Recursively (no loops) creates a String
     * where the data is in reverse order
     * 
     * @param n the current node
     */
    private String reverseQueue(Node n) {
        return null;
    }
}