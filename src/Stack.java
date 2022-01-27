
/**
 * Stack.java
 * @author Sam Yadav
 * @author Sol Valdimarsdottir
 * CIS 22C, Lab 3
 */

import java.util.NoSuchElementException;

public class Stack<T extends Comparable<T>> {
    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int size;

    /**** CONSTRUCTORS ****/

    /**
     * Default constructor for the Stack class
     * 
     * @postcondition a new Stack object with all fields
     *                assigned default values
     */
    public Stack() {
        this.top = null;
        this.size = 0;
    }

    /**
     * Constructor for the Stack class
     * Converts an array into a Stack
     * 
     * @param an array of elements to
     *           copy into the Stack
     */
    public Stack(T[] array) {
        if (array == null) {
            return;
        }
        if (array.length == 0) {
            this.top = null;
            this.size = 0;
        }
        for (int i = array.length - 1; i >= 0; i--) {
            this.push(array[i]);
        }
    }

    /**
     * Copy constructor for the Stack class
     * 
     * @param original the Stack to copy
     * @postcondition a new Stack object which is
     *                an identical, but distinct, copy of original
     *                REQUIRED: THIS METHOD MUST BE IMPLEMENTED
     *                IN O(N) TIME
     */
    public Stack(Stack<T> original) {
        if (original == null) {
            return;
        }

        if (original.getSize() == 0) {
            this.top = null;
            this.size = 0;
        } else {
            this.top = new Node(original.top.data);
            Node temp = original.top;
            Node temp2 = this.top;

            while (temp.next != null) {
                temp = temp.next;
                temp2.next = new Node(temp.data);
                temp2 = temp2.next;
            }
            this.size = original.getSize();
        }
    }

    /**** ACCESSORS ****/

    /**
     * Returns the value stored at the top
     * of the Stack
     * 
     * @return the value at the top of the Stack
     * @precondition !isEmpty()
     * @throws NoSuchElementException when the
     *                                the Stack is empty
     */
    public T peek() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("peek(): Nothing in the Stack to return");
        }
        return this.top.data;
    }

    /**
     * Returns the length of the Stack
     * 
     * @return the length from 0 to n
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Determines whether a Stack is empty
     * 
     * @return whether the Stack is empty
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**** MUTATORS ****/

    /**
     * Inserts a new value at the top of the Stack
     * 
     * @param data the new data to insert
     */
    public void push(T data) {
        Node N = new Node(data);
        N.next = this.top;
        this.top = N;
        this.size++;
    }

    /**
     * Removes the top element of the Stack
     * 
     * @precondition !isEmpty()
     * @throws NoSuchElementException when
     *                                the Stack is empty
     */
    public void pop() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("pop(): Nothing to pop!");
        }
        this.top = this.top.next;
        this.size--;
    }

    /**** ADDITONAL OPERATIONS ****/

    /**
     * Returns the values stored in the Stack
     * as a String, separated by a blank space
     * with a new line character at the end
     * 
     * @return a String of Stack values
     */
    public String toString() {
        Node temp = this.top;
        String result = "";
        while (temp != null) {
            result += temp.data + " ";
            temp = temp.next;
        }

        return result + "\n";
    }

    /**
     * Determines whether two Stacks contain
     * the same data in the same order
     * 
     * @param o the Object to compare to this Stack
     * @return whether o and this are equal Stacks
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Stack)) {
            return false;
        }

        Stack<T> obj = (Stack<T>) o;
        if (this.size != obj.size) {
            return false;
        }

        Node thisTemp = this.top;
        Node objTemp = obj.top;
        while (thisTemp != null) {
            if (!(thisTemp.data.equals(objTemp.data))) {
                return false;
            }
            thisTemp = thisTemp.next;
            objTemp = objTemp.next;
        }
        return true;
    }

    /**
     * Recursively (no loops) creates a String
     * where the data is in reverse order
     * by calling the private helper method
     */
    public String reverseStack() {
        return isEmpty() ? "\n" : this.reverseStack(this.top) + " \n";
    }

    /**
     * Determines whether the Stack
     * is sorted from smallest to largest
     * by calling its recursive helper
     * 
     * @throws NoSuchElementException
     * @return whether the Stack is sorted
     */
    public boolean isSorted() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("isSorted(): Stack is empty");
        }

        return this.isSorted(this.top);
    }

    /**
     * Uses the iterative linear search
     * algorithm to locate an element
     * 
     * @param element the value to search for
     * @return whether the element is present
     *         in the Queue
     *         Note that in the case length==0
     *         the element is considered not found
     */
    public boolean linearSearch(T element) {
        Node temp = this.top;
        while (temp != null) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    /**
     * Uses the recursive binarySearch algorithm
     * to determine if a specific element is in the Stack
     * by calling the private helper method binarySearch
     * 
     * @param value the value to search for
     * @return whether the element is present
     *         in the Queue
     * @precondition isSorted()
     * @throws IllegalStateException when the
     *                               precondition is violated.
     */
    public boolean binarySearch(T value) throws IllegalStateException {
        if (!isSorted()) {
            throw new IllegalStateException("binarySearch(): Cannot perform on unsorted stack.");
        }

        if (this.binarySearch(0, this.size - 1, value) != -1) {
            return true;
        }

        return false;
    }

    /** RECURSIVE HELPER METHODS */

    /**
     * Recursively (no loops) creates a String
     * where the data is in reverse order
     * 
     * @param n the current node
     */
    private String reverseStack(Node n) {
        if (n.next != null) {
            return reverseStack(n.next) + " " + n.data.toString();
        }
        return n.data.toString();
    }

    /**
     * Helper method to isSorted
     * Recursively determines whether data
     * is sorted from smallest to largest
     * 
     * @param node the current node
     * @return whether the data is sorted
     *         in ascending order
     */
    private boolean isSorted(Node node) {
        if (node.next == null) {
            return true;
        }
        if (node.data.compareTo(node.next.data) < 0) {
            return isSorted(node.next);
        }
        return false;

    }

    /**
     * Searches for the specified value in
     * by implementing the recursive
     * binarySearch algorithm
     * 
     * @param low   the lowest bounds of the search
     * @param high  the highest bounds of the search
     * @param value the value to search for
     * @return the location at which value is located
     *         from 1 to length or -1 to indicate not found
     */
    private int binarySearch(int low, int high, T value) {
        if (high < low) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        Node temp = this.top;
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }

        if (temp.data.equals(value)) {
            return mid;
        } else if (temp.data.compareTo(value) > 0) {
            return binarySearch(low, mid - 1, value);
        } else if (temp.data.compareTo(value) < 0) {
            return binarySearch(mid + 1, high, value);
        }

        return -1;
    }

}