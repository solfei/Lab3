
/**
 * QueueTest.java
 * @author Jennifer Parrish
 * CIS 22C, Lab 3
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.NoSuchElementException;

class QueueArrayTest {
    private QueueArray<String> q1;
    private QueueArray<Integer> q2;
    private QueueArray<Double> q3;

    void setUp() {
        q1 = new QueueArray<>();
        for (int i = 'A'; i < 'M'; i++) {
            q1.enqueue("" + (char) i);
        }
        q2 = new QueueArray<>();
        q3 = new QueueArray<>(new Double[] { 1.1, 2.2, 3.3, 4.4 });
    }

    @Test
    void testQueue() {
        setUp();
        assertThrows(NoSuchElementException.class, () -> {
            q2.getFront();
        });
        assertTrue(q2.isEmpty());

    }

    @Test
    void testQueueTArray() {
        setUp();
        assertEquals(1.1, q3.getFront());
        assertEquals("1.1 2.2 3.3 4.4 \n", q3.toString());
        assertEquals(4, q3.getSize());
        String[] array = null;
        assertEquals(0, new QueueArray<String>(array).getSize());
    }

    // @Test
    // void testQueueQueueOfT() {
    // setUp();
    // QueueArray<String> nullQ = null;
    // QueueArray<String> copy = new QueueArray<>(nullQ);
    // assertEquals(0, copy.getSize());
    // copy = new QueueArray<>(q1);
    // assertEquals("A", copy.getFront());
    // assertEquals(q1.toString(), copy.toString());
    // // checking for deep copy
    // copy.enqueue("D");
    // assertNotEquals(copy.getSize(), q1.getSize());
    // }

    @Test
    void testGetFront() {
        setUp();
        assertThrows(NoSuchElementException.class, () -> {
            q2.getFront();
        });
        assertEquals("A", q1.getFront());
        assertEquals(1.1, q3.getFront());
    }

    @Test
    void testGetSize() {
        setUp();
        assertEquals(12, q1.getSize());
        assertEquals(0, q2.getSize());
        assertEquals(4, q3.getSize());
    }

    @Test
    void testIsEmpty() {
        setUp();
        assertTrue(q2.isEmpty());
        assertFalse(q1.isEmpty());
    }

    @Test
    void testEnqueue() {
        setUp();
        assertEquals("A", q1.getFront());
        assertEquals(12, q1.getSize());
        assertEquals(1.1, q3.getFront());
    }

    @Test
    void testDequeue() {
        setUp();
        assertThrows(NoSuchElementException.class, () -> {
            q2.dequeue();
        });
        q1.dequeue();
        assertEquals("B", q1.getFront());
        q3.dequeue();
        q3.dequeue();
        q3.dequeue();
        q3.dequeue();
        assertTrue(q3.isEmpty());
    }

    @Test
    void testToString() {
        setUp();
        assertEquals("A B C D E F G H I J K L \n", q1.toString());
        assertEquals("1.1 2.2 3.3 4.4 \n", q3.toString());
        assertEquals("\n", q2.toString());
    }

    @Test
    void testEqualsObject() {
        setUp();
        assertTrue(q1.equals(q1));
        assertFalse(q1.equals(new String("A B C D E F G H I J K L")));
        for (int i = 0; i < 9; i++) {
            q1.dequeue();
        }
        QueueArray<String> test = new QueueArray<>();
        test.enqueue(new String("J"));
        test.enqueue(new String("K"));
        test.enqueue(new String("L"));
        assertTrue(q1.equals(test));
        test.dequeue();
        assertFalse(q1.equals(test));
        QueueArray<Double> test2 = new QueueArray<>(new Double[] { 1.1, 2.2, 3.2, 4.4 });
        assertFalse(test2.equals(q3));
        assertFalse(test2.equals(test));

    }

    @Test
    void testReverseQueue() {
        setUp();
        QueueArray<String> q = new QueueArray<>();
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        assertEquals("C B A \n", q.reverseQueue());
        assertEquals("\n", q2.reverseQueue());
        assertEquals("4.4 3.3 2.2 1.1 \n", q3.reverseQueue());
    }

}