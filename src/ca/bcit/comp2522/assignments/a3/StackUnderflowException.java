package ca.bcit.comp2522.assignments.a3;

/**
 * StackUnderflowException class, extended from Exception class.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class StackUnderflowException extends Exception {
    /**
     * StackUnderflowException constructor.
     * @param message error message as string
     */
    public StackUnderflowException(String message) {
        super(message);
    }
}

