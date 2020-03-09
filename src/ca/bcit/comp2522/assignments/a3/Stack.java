package ca.bcit.comp2522.assignments.a3;

/**
 * Stack class.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class Stack {

    /**
     * Array of stacked value.
     */
    private int[] stackedValues;

    /**
     * Count of a stack made.
     */
    private int count;

    /**
     * Constructs stack with count = 0, and array of stacked value.
     * Throws error if given parameter of size of array is smaller than 1.
     *
     * @param sizeOfArray size of array as int to make array upon constructing stack.
     */
    public Stack(int sizeOfArray) {
        if (sizeOfArray < 1) {
            throw new IllegalArgumentException("Size of the array must be at least 1");
        }
        this.count = 0;
        this.stackedValues = new int[sizeOfArray];
    }

    /**
     * The total number of elements that could fit into the array.
     *
     * @return capacity of stack in integer
     */
    public int capacity() {
        return stackedValues.length;
    }

    /**
     * Counts the current number of elements in the array.
     *
     * @return size of array
     */
    public int size() {
        return count;
    }

    /**
     * Returns unused space of the stack.
     *
     * @return unused size of stack as integer
     */
    public int unused() {
        return capacity() - count;
    }

    /**
     * Push the given integer value as parameter to the top of the stack.
     *
     * @param value value in integer as parameter to be pushed to stack
     * @throws StackOverflowException throws error if stack is full and can not perform the method
     */
    public void push(int value) throws StackOverflowException {
        if (unused() == 0) {
            throw new StackOverflowException("error: stack full");
        }
        stackedValues[count] = value;
        count++;
    }

    /**
     * Returns value from stack and remove it from stack.
     *
     * @return removed value from stack as integer
     * @throws StackOverflowException throws error if stack is empty
     */
    public int pop() throws StackUnderflowException {
        if (count == 0) {
            throw new StackUnderflowException("error: stack empty");
        }
        int elementToRemove = stackedValues[count - 1];
        count--;
        return elementToRemove;
    }

    /**
     * Returns the value from stack without removing the value from stack.
     *
     * @return value in the stack as integer
     * @throws StackUnderflowException throws error if the stack is empty
     */
    public int peek() throws StackUnderflowException {
        if (count == 0) {
            throw new StackUnderflowException("error: stack empty");
        }
        return stackedValues[count - 1];
    }
}
