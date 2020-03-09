package ca.bcit.comp2522.assignments.a3;

/**
 * StackOverflowException class, extended from Exception class.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class StackOverflowException extends Exception {
    /**
     * StackOverflowException constructor.
     * @param message error message as string
     */
    public StackOverflowException(String message) {
        super(message);
    }
}
