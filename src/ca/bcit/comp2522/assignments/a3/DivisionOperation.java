package ca.bcit.comp2522.assignments.a3;

/**
 * DivisionOperation class extending AbstractOperation abstract class.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class DivisionOperation extends AbstractOperation {


    /**
     * Division symbol as character.
     */
    private static final char DIVISION_CODE = '/';

    /**
     * DivisionOperation constructor.
     */
    public DivisionOperation() {
        super(DIVISION_CODE);
    }

    /**
     * Returns the basic blueprint of the division operation to the user.
     *
     * @param operandA first operand of the math operation
     * @param operandB second operand of the math operation
     * @return result as integer
     */
    @Override
    public int perform(int operandA, int operandB) {
        return operandA / operandB;
    }

    /**
     * Returns a string representation of DivisionOperation of superclass.
     *
     * @return a string representation of DivisionOperation of superclass.
     */
    @Override
    public String toString() {
        return "DivisionOperation{}";
    }
}
