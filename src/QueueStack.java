
/**
* Queue class - Two Stack Version
 * @author Sam Yadav
 * @author Sol Valdimarsdottir
* CIS 22C, Lab 3
*/

import java.util.NoSuchElementException;

public class QueueStack<T extends Comparable<T>> implements Q<T> {
    private Stack<T> stack1; // stack1.top = our new front
    private Stack<T> stack2; // stack2.top = our new end

    /**** CONSTRUCTORS ****/

    /**
     * Default constructor for the Queue class
     */
    public QueueStack() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /**
     * Converts an array into a Queue
     * 
     * @param array the array to copy into the
     *              array
     */
    public QueueStack(T[] array) {
        if (array == null) {
            return;
        }

        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            this.enqueue(array[i]);
        }

    }

    /**
     * Copy constructor for the Queue class
     *
     * @param original the Queue to copy
     * @postcondition a new Queue object which is an identical,
     *                but distinct, copy of original
     */
    public QueueStack(QueueStack<T> original) {
        if (original == null) {
            return;
        } else if (original.getSize() == 0) {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        this.stack1 = new Stack<>(original.stack1);
        this.stack2 = new Stack<>(original.stack2);
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
        if (this.stack1.isEmpty() && this.stack2.isEmpty()) {
            throw new NoSuchElementException("getFront(): Queue is empty.");
        }
        if (this.stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.peek());
                stack2.pop();
            }
        }

        return this.stack1.peek();
    }

    /**
     * Returns the size of the Queue
     * 
     * @return the size from 0 to n
     */
    public int getSize() {
        if (!(this.stack1 instanceof Stack) && !(this.stack2 instanceof Stack)) {
            return 0;
        }

        return this.stack1.getSize() + this.stack2.getSize();
    }

    /**
     * Determines whether a Queue is empty
     * 
     * @return whether the Queue contains
     *         no elements
     */
    public boolean isEmpty() {
        return this.stack1.isEmpty() && this.stack2.isEmpty();
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
        this.stack2.push(data);
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
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new NoSuchElementException("dequeue: Queue is empty.");
        }
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.peek());
                stack2.pop();
            }
        }
        stack1.pop();
    }

    /**
     * Creates a String of the Queue in reverse order
     * 
     * @return a Queue in reverse order
     */
    public String reverseQueue() {
        if (this.stack1.isEmpty() && this.stack2.isEmpty()) {
            return "\n";
        }

        Stack<T> temp1 = new Stack<>(this.stack1);
        Stack<T> temp2 = new Stack<>(this.stack2);
        String result = "";

        if (this.stack1.isEmpty()) {
            // pay attention to stack2!!!!!
            while (!temp2.isEmpty()) {
                result += temp2.peek().toString() + " ";
                temp2.pop();
            }
        } else if (this.stack2.isEmpty()) {
            // pay attention to stack1!!!!!
            while (!temp1.isEmpty()) {
                result = temp1.peek().toString() + " " + result;
                temp1.pop();
            }
        } else {
            while (!temp2.isEmpty()) {
                result += temp2.peek().toString() + " ";
                temp2.pop();
            }
            while (!temp1.isEmpty()) {
                result = temp1.peek().toString() + " " + result;
                temp1.pop();
            }
        }

        return result + "\n";
    }

    /**** ADDITONAL OPERATIONS ****/

    /**
     * Returns the values stored in the Queue as a String, separated by a blank
     * space with a new line character at the end
     *
     * @return a String of Queue values
     */
    @Override
    public String toString() {
        if (this.stack1.isEmpty() && this.stack2.isEmpty()) {
            return "\n";
        }

        Stack<T> temp1 = new Stack<>(this.stack1);
        Stack<T> temp2 = new Stack<>(this.stack2);
        String result = "";

        if (this.stack1.isEmpty()) {
            // pay attention to stack2!!!!!
            while (!temp2.isEmpty()) {
                result = temp2.peek().toString() + " " + result;
                temp2.pop();
            }
        } else if (this.stack2.isEmpty()) {
            // pay attention to stack1!!!!!
            while (!temp1.isEmpty()) {
                result += temp1.peek().toString() + " ";
                temp1.pop();
            }
        } else {
            while (!temp2.isEmpty()) {
                result = temp2.peek().toString() + " " + result;
                temp2.pop();
            }
            while (!temp1.isEmpty()) {
                result += temp1.peek().toString() + " ";
                temp1.pop();
            }
        }

        return result + "\n";
    }

    /**
     * Determines whether two Queues contain the same values in the same order
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

        if (!(o instanceof QueueStack)) {
            return false;
        }

        QueueStack<T> obj = (QueueStack<T>) o;
        obj.getFront();
        this.getFront();

        return this.stack1.equals(obj.stack1) && this.stack2.equals(obj.stack2);
    }

}
