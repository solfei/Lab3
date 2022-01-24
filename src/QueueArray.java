
/**
* Queue class - Array Version
* @author
* @author
* CIS 22C, Lab 3
*/

import java.util.NoSuchElementException;

public class QueueArray<T> implements Q<T> {
    private T[] queue;
    private int curr_size;

    /**** CONSTRUCTORS ****/

    /**
     * Default constructor for the Queue class
     * with an initial length of 10 and
     * no elements
     */
    @SuppressWarnings("unchecked")
    public QueueArray() {
        queue = (T[]) new Object[10];
        curr_size = 0;

    }

    /**
     * Converts an array into a Queue
     * 
     * @param array the array to copy into the array
     */
    @SuppressWarnings("unchecked")
    public QueueArray(T[] array) {
        if (array == null) {
            return;
        }
        if (array.length == 0) {
            queue = (T[]) new Object[10];
            curr_size = 0;
        }
        this.queue = (T[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            this.enqueue(array[i]);
        }

    }

    /**
     * Copy constructor for the Queue class
     * 
     * @param original the Queue to copy
     * @postcondition a new Queue object which is
     *                an identical, but distinct, copy of original
     */
    @SuppressWarnings("unchecked")
    public QueueArray(QueueArray<T> original) {
        if (original == null) {
            return;
        }

        if (original.getSize() == 0) {
            queue = (T[]) new Object[10];
            curr_size = 0;
        } else {
            this.queue = (T[]) new Object[original.getSize()];
            for (int i = 0; i < original.getSize(); i++) {
                this.enqueue(original.queue[i]);
            }
        }
    }

    /**** ACCESSORS ****/

    // Add methods here
    /**
     * Returns the value stored at the front
     * of the Queue
     * 
     * @return the value at the front of the queue
     * @precondition !isEmpty()
     * @throws NoSuchElementException when the
     *                                precondition is violated
     */
    public T getFront() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("getFront(): Queue is empty");
        }
        return this.queue[0];
    }

    /**
     * Returns the size of the Queue
     * 
     * @return the size from 0 to n
     */
    public int getSize() {
        return this.curr_size;
    }

    /**
     * Determines whether a Queue is empty
     * 
     * @return whether the Queue contains
     *         no elements
     */
    public boolean isEmpty() {
        return this.curr_size == 0;
    }

    /**** MUTATORS ****/

    // Add methods here
    /**
     * Inserts a new value at the end of the Queue
     * 
     * @param data the new data to insert
     * @postcondition a new node at the end of the Queue
     */
    public void enqueue(T data) {
        // checking if current size is larger than size? if so resize()
        if (this.curr_size == this.queue.length) {
            this.resize();
        }
        curr_size++;

        this.queue[curr_size - 1] = data;

    }

    /**
     * Removes the front element in the Queue
     * 
     * @precondition !isEmpty()
     * @throws NoSuchElementException when
     *                                the precondition is violated
     * @postcondition the front element has
     *                been removed
     */
    public void dequeue() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("dequeue(): Queue is empty!");
        }

        for (int i = 0; i < this.curr_size - 1; i++) {
            this.queue[i] = this.queue[i + 1];
        }

        this.curr_size--;

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
        String result = "";

        for (int i = 0; i < this.curr_size; i++) {
            result += this.queue[i] + " ";
        }

        return result + "\n";
    }

    /**
     * Determines whether two Queues contain
     * the same values in the same order
     *
     * @param o the Object to compare to this
     * @return whether o and this are equal
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof QueueArray)) {
            return false;
        }
        QueueArray<T> obj = (QueueArray<T>) o;
        if (this.getSize() != obj.getSize()) {
            return false;
        }

        for (int i = 0; i < this.curr_size; i++) {
            if (!(this.queue[i].equals(obj.queue[i]))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates a String of the Queue in reverse orde
     * 
     * @return a Queue in reverse order
     */
    public String reverseQueue() {
        return "";
    }

    /** PRIVATE HELPER METHODS */

    /**
     * private helper method for reverseQueue
     *
     * @param index the current index
     * @return a String of this Queue in reverse
     *         order
     */
    private String reverseQueue(int index) {
        return null;
    }

    /**
     * Increases the current array
     * size by 10
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) new Object[this.queue.length + 10];

        for (int i = 0; i < curr_size; i++) {
            newArray[i] = this.queue[i];
        }

        this.queue = newArray;
    }

    public static void main(String[] args) {
        QueueArray<String> q1 = new QueueArray<>();
        for (int i = 'A'; i < 'M'; i++) {
            q1.enqueue("" + (char) i);
        }
        QueueArray<Integer> q2 = new QueueArray<>();
        QueueArray<Double> q3 = new QueueArray<>(new Double[] { 1.1, 2.2, 3.3, 4.4 });
    }
}
