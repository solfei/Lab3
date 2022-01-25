
// /**
// * Queue class - Two Stack Version
// * @author
// * @author
// * CIS 22C, Lab 3
// */

// import java.util.NoSuchElementException;

// public class QueueStack<T extends Comparable<T>> implements Q<T> {
// // What we need
// // a front and an end (to add to end and remove from the front) FIFO

// // LinkedList -> front node and end node (linear)
// // frontNode -> n1 -> n2 -> n3 -> endNode -> null
// // [0][1][2][3]

// // stack1 -> linkedlist
// // top (end) -> n1 -> n2 -> n3 -> null
// // add to 1 (1.push) -> for example we adding new data - 10
// // this.stack1.push(10);
// // top (end) 10 -> n0 -> n1 -> n2 -> n3 -> null
// // this.stack1.pop()
// // top (end) -> n1 -> n2 -> n3 -> null

// // stack2 -> linkedlist (we can only )
// //
// //

// // top (end) -> n1 -> n2 -> n3 -> null
// // top (front) n3 -> n2 -> n1 -> n0 -> null

// // LinkedList
// // n0 -> n1 -> n2 -> n3 -> null

// // front(top) n0 -> n1 -> n2 -> n3 -> null (stack1)
// // last(top) n3 -> n2 -> n1 -> n0 -> null (stack2)

// // last(top) n4 -> n3 -> n2 -> n1 -> n0 -> null (stack2.push(n4))

// // front(top) n0 -> n1 -> n2 -> n3 -> null (stack1)

// // stack1 = new Stack<>;
// // Node temp = stack2.top;
// // while (temp.next != null){
// // temp = temp.next;
// // }
// // stack

// private Stack<T> stack1; // stack1.top = our new front
// private Stack<T> stack2; // stack2.top = our new end

// /**** CONSTRUCTORS ****/

// /**
// * Default constructor for the Queue class
// */
// public QueueStack() {

// }

// /**
// * Converts an array into a Queue
// *
// * @param array the array to copy into the
// * array
// */
// public QueueStack(T[] array) {

// }

// /**
// * Copy constructor for the Queue class
// *
// * @param original the Queue to copy
// * @postcondition a new Queue object which is an identical,
// * but distinct, copy of original
// */
// public QueueStack(Queue<T> original) {

// }

// /**** ACCESSORS ****/

// // Add methods here

// /**** MUTATORS ****/

// // Add methods here

// /**** ADDITONAL OPERATIONS ****/

// /**
// * Returns the values stored in the Queue as a String, separated by a blank
// * space with a new line character at the end
// *
// * @return a String of Queue values
// */
// @Override
// public String toString() {
// return null;
// }

// /**
// * Determines whether two Queues contain the same values in the same order
// *
// * @param o the Object to compare to this
// * @return whether o and this are equal
// */
// @Override
// public boolean equals(Object o) {
// return false;
// }

// }
