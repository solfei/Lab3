import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * StackTest
 */
class StackTest {
    private Stack<String> q1;
    private Stack<Integer> q2;
    private Stack<Double> q3;

    void setUp() {
        q1 = new Stack<>();
        for (int i = 'L'; i >= 'A'; i--) {
            q1.push("" + (char) i);
        }
        q2 = new Stack<>();
        q3 = new Stack<>(new Double[] { 1.1, 2.2, 3.3, 4.4 });
    }

    @Test
    void testQueue() {
        setUp();
        assertThrows(NoSuchElementException.class, () -> {
            q2.peek();
        });
        assertTrue(q2.isEmpty());

    }

    @Test
    void testQueueTArray() {
        setUp();
        assertEquals(1.1, q3.peek());
        assertEquals("1.1 2.2 3.3 4.4 \n", q3.toString());
        assertEquals(4, q3.getSize());
        String[] array = null;
        assertEquals(0, new Stack<String>(array).getSize());
    }

    @Test
    void testStackStackOfT() {
        setUp();
        Stack<String> nullQ = null;
        Stack<String> copy = new Stack<>(nullQ);
        assertEquals(0, copy.getSize());
        copy = new Stack<>(q1);
        assertEquals("A", copy.peek());
        assertEquals(q1.toString(), copy.toString());
        // checking for deep copy
        copy.push("D");
        assertNotEquals(copy.getSize(), q1.getSize());
    }

    @Test
    void testPeek() {
        setUp();
        assertThrows(NoSuchElementException.class, () -> {
            q2.peek();
        });
        assertEquals("A", q1.peek());
        assertEquals(1.1, q3.peek());
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
    void testPush() {
        setUp();
        assertEquals("A", q1.peek());
        assertEquals(12, q1.getSize());
        assertEquals(1.1, q3.peek());
    }

    @Test
    void testPop() {
        setUp();
        assertThrows(NoSuchElementException.class, () -> {
            q2.pop();
        });
        q1.pop();
        assertEquals("B", q1.peek());
        q3.pop();
        q3.pop();
        q3.pop();
        q3.pop();
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
            q1.pop();
        }
        Stack<String> test = new Stack<>();
        test.push(new String("L"));
        test.push(new String("K"));
        test.push(new String("J"));
        assertTrue(q1.equals(test));
        test.pop();
        assertFalse(q1.equals(test));
        Stack<Double> test2 = new Stack<>(new Double[] { 1.1, 2.2, 3.2, 4.4 });
        assertFalse(test2.equals(q3));
        assertFalse(test2.equals(test));

    }

    // @Test
    // void testReverseQueue() {
    // setUp();
    // Stack<String> q = new Stack<>();
    // q.push("A");
    // q.push("B");
    // q.push("C");
    // assertEquals("C B A \n", q.reverseQueue());
    // assertEquals("\n", q2.reverseQueue());
    // assertEquals("4.4 3.3 2.2 1.1 \n", q3.reverseQueue());
    // }

}