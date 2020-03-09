package ca.bcit.comp2522.assignments.a3;

/**
 * SubtractionOperation class extending AbstractOperation abstract class.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class SubtractionOperation extends AbstractOperation {

    /**
     * Subtraction symbol as constructor.
     */
    private static final char SUBTRACTION_CODE = '-';

    /**
     * SubtractionOperation constructor.
     */
    public SubtractionOperation() {
        super(SUBTRACTION_CODE);
    }


    /**
     * Returns the basic blueprint of the math operation to the user.
     *
     * @param operandA first operand of the math operation
     * @param operandB second operand of the math operation
     * @return result as integer
     */
    @Override
    public int perform(int operandA, int operandB) {
        return operandA - operandB;
    }

    /**
     * Returns a string representation of SubtractionOperation of superclass.
     *
     * @return a string representation of SubtractionOperation of superclass.
     */
    @Override
    public String toString() {
        return "SubtractionOperation{}";
    }
}
