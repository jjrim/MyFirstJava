package ca.bcit.comp2522.assignments.a3;

/**
 * Operation, an interface.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public interface Operation {

    /**
     * Returns the operation symbol to the user.
     *
     * @return operation symbol as character.
     */
    char getSymbol();

    /**
     *  Returns the basic blueprint of the math operation to the user.
     *
     * @param operandA first operand of the math operation
     * @param operandB second operand of the math operation
     * @return result as integer
     */
    int perform(int operandA, int operandB);
}
