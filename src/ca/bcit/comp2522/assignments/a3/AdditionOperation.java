package ca.bcit.comp2522.assignments.a3;


/**
 * AdditionOperation class extending AbstractOperation abstract class.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class AdditionOperation extends AbstractOperation {

    /**
     * Addition symbol as character.
     */
    private static final char ADDITION_CODE = '+';
    /**
     * AdditionOperation constructor.
     */
    public AdditionOperation() {
        super(ADDITION_CODE);
    }

    /**
     * Returns the basic blueprint of the addition operation to the user.
     *
     * @param operandA first operand of the math operation
     * @param operandB second operand of the math operation
     * @return result as integer
     */
    @Override
    public int perform(int operandA, int operandB) {
        return operandA + operandB;
    }

    /**
     * Returns a string representation of AdditionOperation of superclass.
     *
     * @return a string representation of AdditionOperation of superclass.
     */
    @Override
    public String toString() {
        return "AdditionOperation{}";
    }
}
