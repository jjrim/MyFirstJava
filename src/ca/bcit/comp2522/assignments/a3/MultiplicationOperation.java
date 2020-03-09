package ca.bcit.comp2522.assignments.a3;

/**
 * MultiplicationOperation class extending AbstractOperation abstract class.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class MultiplicationOperation extends AbstractOperation {

    /**
     * Multiplication sign as a character.
     */
    public static final char MULTIPLICATION_CODE = '*';

    /**
     * MultiplicationOperation constructor.
     */
    public MultiplicationOperation() {
        super(MULTIPLICATION_CODE);
    }

    /**
     * Returns the basic blueprint of the multiplication operation to the user.
     *
     * @param operandA first operand of the math operation
     * @param operandB second operand of the math operation
     * @return result as integer
     */
    @Override
    public int perform(int operandA, int operandB) {
        return operandA * operandB;
    }


    /**
     * Returns a string representation of MultiplicationOperation of superclass.
     *
     * @return a string representation of MultiplicationOperation of superclass.
     */
    @Override
    public String toString() {
        return "MultiplicationOperation{}";
    }
}
