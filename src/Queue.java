
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
        this.front = null;
        this.end = null;
        this.size = 0;
    }

    /**
     * Converts an array into a Queue
     * 
     * @param array the array to copy into
     *              the Queue
     */
    public Queue(T[] array) {
        this();
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            this.enqueue(array[i]);
        }
    }

    /**
     * Copy constructor for the Queue class
     * Makes a deep copy of the parameter
     * 
     * @param aQueue another Queue to copy
     */
    public Queue(Queue<T> aQueue) {
        if (aQueue == null) {
            return;
        }

        if (aQueue.size == 0) {
            this.front = null;
            this.end = null;
            this.size = 0;
        } else {
            Node temp = aQueue.front;
            while (temp != null) {
                enqueue(temp.data);
                temp = temp.next;
            }
        }
    }

    /**** ACCESSORS ****/

    // add methods here
    public T getFront() throws NoSuchElementException {
        if (this.size == 0) {
            throw new NoSuchElementException("getFront(): Queue is empty.");
        }

        return this.front.data;
    }

    /**
     * Returns the size of the Queue
     * 
     * @return the size from 0 to n
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Determines whether a Queue is empty
     * 
     * @return whether the Queue contains
     *         no elements
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**** MUTATORS ****/

    // add methods here

    public void enqueue(T data) {
        Node N = new Node(data);
        if (this.size == 0) {
            this.front = this.end = N;
        } else {
            this.end.next = N;
        }
        size++;
    }

    public void dequeue() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("dequeue(): List is empty!");
        }

        if (this.size == 1) {
            this.front = this.end = null;
        } else {
            this.front = this.front.next;
        }
    }

    public String reverseQueue() {
        String result = "";

        reverseQueue(this.end);

        return result;
    }

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
        StringBuilder result = new StringBuilder("");

        Node temp = this.front;
        while (temp != null) {
            result.append(temp.data);
            temp = temp.next;
        }

        return result.toString() + " \n";
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
        if (this == o) {
            return true;
        }
        if (!(o instanceof Queue)) {
            return false;
        }
        Queue<T> obj = (Queue<T>) o;
        if (this.size != obj.size) {
            return false;
        }
        Node thisTemp = this.front;
        Node objTemp = obj.front;
        while (thisTemp != null) {
            if (!(thisTemp.data.equals(objTemp.data))) {
                return false;
            }
            thisTemp = thisTemp.next;
            objTemp = objTemp.next;
        }
        return true;
    }

    /** RECURSIVE HELPER METHODS */

    /**
     * Recursively (no loops) creates a String
     * where the data is in reverse order
     * 
     * @param n the current node
     */

    private String reverseQueue(Node n) {
        Node temp = this.front;

        if (temp.next != n) {
            temp = temp.next;
            reverseQueue();
        }

        return temp.data.toString();
    }

    public static void main(String[] args) {
        Queue<String> q1 = new Queue<>();
        for (int i = 'A'; i < 'M'; i++) {
            q1.enqueue("" + (char) i);
        }
        Queue<Integer> q2 = new Queue<>();
        Queue<Double> q3 = new Queue<>(new Double[] { 1.1, 2.2, 3.3, 4.4 });

        System.out.println(q2.isEmpty());
        try {
            q2.getFront();
        } catch (Exception e) {
            System.out.println("YAAAY");
        }

        int size = q3.getSize();
        System.out.println("Is getSize() working?... " + (size == 4));
        System.out.println("");

    }
}