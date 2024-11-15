package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

// -------------------------------------------------------------------------
/**
 * Represents a stack implemented using a linked list. This class provides
 * methods to manipulate elements in the stack, including push, pop, peek, and
 * clear.
 * 
 * @author federicotafur
 * @version Mar 18, 2024
 * @param <T>
 */
public class LinkedStack<T>
    implements StackInterface<T>
{
    // ~ Fields ................................................................
    private Node<T> topNode;
    private int size;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Constructs an empty LinkedStack.
     */
    public LinkedStack()
    {
        topNode = null;
        size = 0;
    }


    // ~Public Methods ........................................................
    /**
     * Returns the number of elements in the stack.
     * 
     * @return The size of the stack.
     */
    public int size()
    {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * Removes all elements from the stack.
     */
    public void clear()
    {
        topNode = null;
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * Checks if the stack is empty.
     * 
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return (size == 0);
    }


    /**
     * Returns a string representation of the stack.
     * 
     * @return A string representing the stack.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[");
        Node<T> currentNode = topNode;
        while (currentNode != null)
        {
            sb.append(currentNode.getData());
            if (currentNode.getNextNode() != null)
            {
                sb.append(", ");
            }
            currentNode = currentNode.getNextNode();
        }
        sb.append("]");
        return sb.toString();
    }


    // ----------------------------------------------------------
    /**
     * Adds an element to the top of the stack.
     * 
     * @param anEntry
     *            The element to be added.
     */
    public void push(T anEntry)
    {
        if (isEmpty())
        {
            topNode = new Node<T>(anEntry);
        }
        else
        {
            Node<T> newNode = new Node<>(anEntry, topNode);
            topNode = newNode;
        }

        size++;
    }


    // ----------------------------------------------------------
    /**
     * Removes and returns the element at the top of the stack.
     * 
     * @return The element removed from the top of the stack.
     * @throws EmptyStackException
     *             if the stack is empty.
     */
    public T pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        T topData = topNode.getData();
        Node<T> nextNode = topNode.getNextNode();
        topNode = nextNode;
        size--;
        return topData;
    }


    // ----------------------------------------------------------
    /**
     * Retrieves the element at the top of the stack without removing it.
     * 
     * @return The element at the top of the stack.
     * @throws EmptyStackException
     *             if the stack is empty.
     */
    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }

    /**
     * Represents a node in the linked stack.
     * 
     * @param <T>
     *            The type of data stored in the node.
     */
    private static class Node<T>
    {
        private T data;
        private Node<T> nextNode;

        public Node(T data)
        {
            this.setData(data);
        }


        /**
         * Constructs a node with the specified data and next node.
         * 
         * @param data
         *            The data stored in the node.
         * @param nextNode
         *            The next node in the linked list.
         */

        public Node(T data, Node<T> nextNode)
        {
            this(data);
            this.setNextNode(nextNode);
        }


        /**
         * Retrieves the data stored in the node.
         * 
         * @return The data stored in the node.
         */
        public T getData()
        {
            return data;
        }


        @SuppressWarnings("unused")
        public void setData(T data)
        {
            this.data = data;
        }


        @SuppressWarnings("unused")
        public void setNextNode(Node<T> n)
        {
            nextNode = n;
        }


        /**
         * Retrieves the next node in the linked list.
         * 
         * @return The next node in the linked list.
         */
        public Node<T> getNextNode()
        {
            return nextNode;
        }
    }
}
