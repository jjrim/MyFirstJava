package ca.bcit.comp2522.labs.lab02;

import java.util.Random;

/**
 * Lab02
 * Mathematics class.
 *
 * @author Jay Rim
 * @version 2020
 */
public class Mathematics {

    /**
     * One foot to kilometer ratio, 0.003048.
     *
     */
    public static final double ONE_FOOT_TO_KILOMETRE_RATIO = 0.0003048;

    /**
     * Value of PI in double, 3.14159.
     *
     */
    public static final double PI = 3.14159;

    /**
     * Maximum bound for random number in int, 20.
     */
    public static final int RANDOM_NUMBER_MAX_BOUND = 20;

    /**
     * Minmum bound for random number in int, 10.
     */
    public static final int RANDOM_NUMBER_MIN_BOUND = 10;

    /**
     * Restriction of what random number should not be in int, 15.
     */
    public static final int WRONG_RANDOM_NUMBER = 15;

    /**
     * Calculates the area of circle using radius of the circle.
     *
     * @param radius radius of a circle, a double
     * @return area of circle, a double
     */
    public double getCircleArea(double radius) {
        return radius * radius * PI;
    }

    /**
     * Calculates the area of square with a side of square.
     *
     * @param side side of a square, a double
     * @return area of square, a double
     */
    public double getSquareArea(double side) {
        return side * side;
    }

    /**
     * Calculates the sum of two numbers of given parameter.
     *
     * @param firstNum first number to be added with the second number, a double
     * @param secondNum second number to be added with the first number, a double
     * @return sum of two numbers, a double
     */
    public double add(double firstNum, double secondNum) {
        return firstNum + secondNum;
    }

    /**
     * Multiplies two given number.
     *
     * @param firstNum first number to be multiplied with the second number, a double
     * @param secondNum second number to be multiplied with the first number, a double
     * @return multiplied result of two numbers, double
     */
    public double multiply(double firstNum, double secondNum) {
        return firstNum * secondNum;
    }

    /**
     * Calculates the difference of two numbers.
     *
     * @param firstNum number to subtract, a double
     * @param secondNum number to be subtracted from, a double
     * @return subtracted result value, a double
     */
    public double subtract(double firstNum, double secondNum) {
        return firstNum - secondNum;
    }

    /**
     * Divides first given number by second given number.
     *
     * @param firstNum number to be divided, a double
     * @param secondNum number to perform division with, a double
     * @return value of division between the two numbers, a double
     */
    public double divide(double firstNum, double secondNum) {
        if (secondNum == 0) {
            return 0;
        } else {
            return firstNum / secondNum;
        }
    }


    /**
     * Get the absolute value of given parameter.
     *
     * @param numberToAbsolute number to convert to absolute value, a int
     * @return converted value that is absolute value, a int
     */
    public int absoluteValue(int numberToAbsolute) {
        return Math.abs(numberToAbsolute);
    }

    /**
     * Converts feet to kilometers.
     *
     * @param feetToConvert distance in feet to be converted to kilometers.
     * @return converted value in kilometers
     */
    public double convertFeetToKilometres(double feetToConvert) {
        return feetToConvert * ONE_FOOT_TO_KILOMETRE_RATIO;
    }

    /**
     * Determines if the given parameter value is even. If even returns true, else false.
     *
     * @param numberToTest number to test if this number is even number, a integer
     * @return true if even, else false
     */
    public boolean isEven(int numberToTest) {
        return numberToTest % 2 == 0;
    }

    /**
     * Calculates the sum of all the even numbers in the given parameter number.
     *
     * @param numberToSumEvens given number to find all the even numbers
     * @return sum of all the even numbers
     */
    public int sumOfEvens(int numberToSumEvens) {
        int i;
        int answer = 0;
        if (numberToSumEvens > 0) {
            for (i = 0; i <= numberToSumEvens; i++) {
                if (i % 2 == 0) {
                    answer = answer + i;
                }
            }
        } else {
            for (i = 0; i <= Math.abs(numberToSumEvens); i++) {
                if (i % 2 == 0) {
                    answer = answer - i;
        }
    }
        }
        return answer;
    }

    /**
     * Calculates sum of integers of given parameter.
     *
     * @param numberToSumInts given parameter to calculate sum of integers, an int
     * @return sum of integers, an int
     */
    public int sumOfInts(int numberToSumInts) {
        if (numberToSumInts <= 0) {
            return 0;
        } else {
            return (numberToSumInts * (numberToSumInts + 1)) / 2;
        }
    }

    /**
     * Tests if given parameter value is positive.
     *
     * @param numToTestPositive number to test if it is positive, a integer
     * @return true if positive, else false
     */
    public boolean isPositive(int numToTestPositive) {
        return numToTestPositive > 0;
    }

    public int sumOfProducts(int firstNum, int secondNum) {
        int count = firstNum / secondNum;
        int answer2 = 0;
        if (firstNum > 0) {
            for (int i = 1; i <= count; i++) {
                answer2 = answer2 + secondNum * i;
            }
        } else {
            for (int i = 1; i <= Math.abs(count); i++) {
                answer2 = answer2 - secondNum * i;
            }
        }
        return answer2;
    }

    /**
     * Get a random number between ten and twenty but not fifteen.
     *
     * @return a random integer value between ten and twenty but not fifteen
     */
    public int getRandomNumberBetweenTenAndTwentyButNotFifteen() {
        Random random = new Random();
        int answer = random.nextInt(RANDOM_NUMBER_MAX_BOUND + 1 - RANDOM_NUMBER_MIN_BOUND)
                + RANDOM_NUMBER_MIN_BOUND;
        while (answer == WRONG_RANDOM_NUMBER) {
            answer = random.nextInt(RANDOM_NUMBER_MAX_BOUND + 1 - RANDOM_NUMBER_MIN_BOUND)
                    + RANDOM_NUMBER_MIN_BOUND;
        }
        return answer;
    }
}
