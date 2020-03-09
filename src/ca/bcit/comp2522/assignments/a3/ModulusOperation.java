package ca.bcit.comp2522.assignments.a3;

/**
 * ModulusOperation class extending AbstractOperation abstract class.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class ModulusOperation extends AbstractOperation {


    /**
     * Modulus symbol as character.
     */
    private static final char MODULUS_CODE = '%';

    /**
     * ModulusOperation constructor.
     *
     */
    public ModulusOperation() {
        super(MODULUS_CODE);
    }

    /**
     * Returns the basic blueprint of the modulus operation to the user.
     *
     * @param operandA first operand of the math operation
     * @param operandB second operand of the math operation
     * @return result as integer
     */
    @Override
    public int perform(int operandA, int operandB) {
        return operandA % operandB;
    }

    /**
     * Returns a string representation of ModulusOperation of superclass.
     *
     * @return a string representation of ModulusOperation of superclass.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}

