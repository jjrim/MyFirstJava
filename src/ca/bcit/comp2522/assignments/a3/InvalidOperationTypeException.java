package ca.bcit.comp2522.assignments.a3;

/**
 * InvalidOperationTypeException class, extended from Exception class.
 * Displays error message when operation type is invalid.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class InvalidOperationTypeException extends Exception {

    /**
     * InvalidOperationTypeException constructor.
     * @param message error message as string
     */
    public InvalidOperationTypeException(String message) {
        super(message);
    }

}
