package ca.bcit.comp2522.assignments.a3;

/**
 * AbstractOperation, an abstract class implementing Operation interface.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public abstract class AbstractOperation implements Operation {

    /**
     * Operation type symbol as sign.
     */
    protected char operationType;

    /**
     * Abstraction operation constructor that constructs operation type.
     *
     * @param operationType operation type symbol sign to use as constructor
     */
    public AbstractOperation(char operationType) {
        this.operationType = operationType;
    }
    /**
     * Accessor method to return operation type symbol.
     *
     * @return Operation type symbol as character
     */
    public final char getSymbol() {
        return operationType;
    }

}
