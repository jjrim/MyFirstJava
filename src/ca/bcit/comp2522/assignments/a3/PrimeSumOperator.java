package ca.bcit.comp2522.assignments.a3;

/**
 * PrimeSumOperator class extending abstract operation.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class PrimeSumOperator extends AbstractOperation {


    /**
     * PrimeSum symbol as character.
     */
    private static final char PRIME_SUM_CODE = '@';

    /**
     * Constructs the PrimeSumOperator.
     *
     */
    public PrimeSumOperator() {
        super(PRIME_SUM_CODE);
    }

    /**
     /**
     * Returns the basic blueprint of the primeSum operation to the user.
     *
     * @param operandA first operand of the math operation
     * @param operandB second operand of the math operation
     * @return result as integer
     */
    @Override
    public int perform(int operandA, int operandB) {
        if (operandA < 0) {
            operandA = 0;
        }
        if (operandB < 0) {
            operandB = 0;
        }
        if (operandA > operandB) {
            int temp = operandA;
            operandA = operandB;
            operandB = temp;
        }
        int sum = 0;
        for (int i = operandB; i >= operandA; i--) {
            boolean isSumPrime = checkPrime(i);
            if (isSumPrime) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * Returns true if parameter is greater than one and remainder is zero, else false.
     *
     * @param numToCheck number to check if it is prime number
     * @return true if prime number, else false
     */
    public boolean checkPrime(int numToCheck) {
        if (numToCheck == 1) {
            return false;
        }
        for (int i = 2; i * i <= numToCheck; i++) {
            if (numToCheck % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a string representation of PrimeSumOperation.
     *
     * @return a string representation of PrimeSumOperation.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}

