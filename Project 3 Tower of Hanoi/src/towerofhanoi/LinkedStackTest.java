package towerofhanoi;

import bag.Node;
import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * The LinkedStackTest class provides test cases for the LinkedStack class. It
 * tests the functionality of methods such as clear, isEmpty, toString, pop, and
 * peek.
 * 
 * @author federicotafur
 * @version Mar 18, 2024
 */
public class LinkedStackTest
    extends student.TestCase
{
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Tests the {@code clear} method of the LinkedStack class. It verifies that
     * the stack is emptied after calling the method.
     */
    public void testClear()
    {
        // Create a new LinkedStack object
        LinkedStack<Integer> stack = new LinkedStack<>();

        // Push some elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Clear the stack
        stack.clear();

        // Verify that the stack is empty
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Tests the {@code isEmpty} method of the LinkedStack class. It verifies
     * that the stack is empty initially, after pushing elements, and after
     * clearing the stack.
     */
    public void testIsEmpty()
    {
        LinkedStack<Integer> stack = new LinkedStack<>();

        assertTrue(stack.isEmpty());

        stack.push(1);

        assertFalse(stack.isEmpty());

        stack.clear();

        assertTrue(stack.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * Tests the {@code toString} method of the LinkedStack class. It verifies
     * that the string representation of the stack is correct when it is empty
     * and when elements are pushed onto it.
     */
    public void testToString()
    {
        LinkedStack<Integer> stack = new LinkedStack<>();

        assertEquals("[]", stack.toString());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals("[3, 2, 1]", stack.toString());
    }


    // ----------------------------------------------------------
    /**
     * Tests the {@code pop} method of the LinkedStack class. It verifies that
     * popping the stack returns the correct elements and updates the size, and
     * that popping from an empty stack throws an EmptyStackException.
     */
    public void testPop()
    {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, (int)stack.pop());
        assertEquals(2, (int)stack.pop());
        assertEquals(1, (int)stack.pop());
        Exception exception = null;
        try
        {
            stack.pop();
        }
        catch (EmptyStackException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }


    // ----------------------------------------------------------
    /**
     * Tests the {@code peek} method of the LinkedStack class. It verifies that
     * peeking the stack returns the correct element without removing it, and
     * that peeking from an empty stack throws an EmptyStackException.
     */
    public void testPeek()
    {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, (int)stack.peek());
        stack.clear();
        Exception exception = null;
        try
        {
            stack.peek();
        }
        catch (EmptyStackException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }



    /**
     * Test method for setNextNode method in Node class. It checks that the next
     * node is correctly set.
     */
    public void testSetNextNode()
    {
        // Create a Node object with data "testData1"
        Node<String> node1 = new Node<>("testData1", null);

        // Create another Node object with data "testData2"
        Node<String> node2 = new Node<>("testData2", null);

        // Set node2 as the next node of node1
        node1.setNext(node2);

        // Verify that the next node of node1 is node2
        assertEquals(node2, node1.getNext());
    }
}
