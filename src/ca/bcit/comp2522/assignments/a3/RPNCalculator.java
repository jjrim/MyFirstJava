package ca.bcit.comp2522.assignments.a3;

import java.util.Scanner;

/**
 * RPN calculator, the driver class.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class RPNCalculator {

    /**
     * Minimum stack size required for calculator.
     */
    public static final int MIN_STACK_SIZE = 2;

    /**
     * Stack required in calculator.
     */
    private Stack stack;

    /**
     * RPN calculator constructor.
     *
     * @param stackSize size of stack in integer as parameter to construct RPN Calculator
     */
    public RPNCalculator(int stackSize) {
        if (stackSize < MIN_STACK_SIZE) {
            throw new IllegalArgumentException();
        }
        this.stack = new Stack(stackSize);
    }

    /**
     * Method of calculator to drive the given formula as argument.
     *
     * @param formula formula to perform calculation
     * @return result of the calculation
     * @throws StackOverflowException throws error if the stack if full
     * @throws StackUnderflowException throws error if the stack goes under the stack size
     * @throws InvalidOperationTypeException throws error if given operation type is invalid
     */
    public int processFormula(final String formula)
            throws StackOverflowException, StackUnderflowException, InvalidOperationTypeException {
        if (formula == null) {
            throw new IllegalArgumentException();
        }

        if (formula.trim().length() == 0) {
            throw new StackUnderflowException("can not proceed with length 0 arguments.");
        }

        Scanner scanner = new Scanner(formula);
        while (scanner.hasNext()) {

            if (scanner.hasNextInt()) {
                String numberInFormulaAsString = scanner.next();
                push(Integer.parseInt(numberInFormulaAsString));
            } else {
                String it = scanner.next();
                Operation operation = getOperation(it.charAt(0));
                perform(operation);
            }
        }

        return getResult();
    }

    /**
     * Pushes the operand.
     *
     * @param operand operand as integer to push
     * @throws StackOverflowException throws error if the stack if full
     */
    void push(final int operand) throws StackOverflowException {
        if (stack.unused() == 0) {
            throw new StackOverflowException("Can not call push");
        }
        stack.push(operand);
    }

    /**
     * Operation method that gets operation symbol. Throws error if symbol is invalid.
     *
     * @param symbol symbol to detect and to change to operation
     * @return Operation symbol as operation
     * @throws InvalidOperationTypeException throws error if operation type is
     *                                       not one of the available symbols.
     */
    private Operation getOperation(final char symbol) throws InvalidOperationTypeException {
        switch (symbol) {
            case '@':
                return new PrimeSumOperator();
            case '/':
                return new DivisionOperation();
            case '%':
                return new ModulusOperation();
            case '+':
                return new AdditionOperation();
            case '*':
                return new MultiplicationOperation();
            case '-':
                return new SubtractionOperation();
            default:
                throw new InvalidOperationTypeException(symbol + "is invalid operation type.");
        }
    }

    /**
     * Gets the result of performed calculation.
     *
     * @return calculated result in integer
     * @throws StackUnderflowException throws error when there is no stack.
     */
    public int getResult() throws StackUnderflowException {
        if (stack.size() == 0) {
            throw new StackUnderflowException("No operands");
        }
        return stack.peek();
    }

    /**
     * Performs calculation with given operation.
     *
     * @param operation operation in Operation data type to perform calculation
     * @throws StackOverflowException throws error if pop() method goes over the stack.
     * @throws StackUnderflowException throws error if pop() method goes smaller than the stack.
     */
    protected void perform(final Operation operation)
            throws StackOverflowException, StackUnderflowException {
        if (operation == null) {
            throw new IllegalArgumentException("Operation can not be null");
        }
        int firstOperands = stack.pop();
        int secondOperands = stack.pop();
        push(operation.perform(secondOperands, firstOperands));
    }

    /**
     * Drives the program by evaluating the RPN calculation provided as
     * a command line argument.
     * <p>
     * Example usage: RPNCalculator 10 "1 2 +"
     * <p>
     * Note that the formula MUST be placed inside of double quotes.
     *
     * @param argv - the command line arguments are the size of the Stack
     *             to be created followed by the expression to evaluate.
     */
    public static void main(String[] argv) {
        //Checks for correct number of command line arguments.
        if (argv.length != 2) {
            System.err.println("Usage: Main <stack size> <formula>");
            System.exit(1);
        }

        //Initializes stack and RPNCalculator.
        final int stackSize = Integer.parseInt(argv[0]);
        final RPNCalculator calculator = new RPNCalculator(stackSize);

        try {
            System.out.println("[" + argv[1] + "] = "
                    + calculator.processFormula(argv[1]));
        } catch (final InvalidOperationTypeException ex) {
            System.err.println("formula can only contain integers, +, -, *, and /");
        } catch (final StackOverflowException ex) {
            System.err.println("too many operands in the formula, increase the stack size");
        } catch (final StackUnderflowException ex) {
            System.err.println("too few operands in the formula");
        }
    }
}
