package ca.bcit.comp2522.labs.lab09;

import java.util.Random;
/**
 * Driver class to simulate logarithmicSort and QuadraticSort.
 *
 * @author Jay Rim
 * @version 2020
 */
public class Driver {
    /**
     * Array size of ten as integer, 10.
     */
    public static final int ARRAY_SIZE_FOR_TEST_TEN = 10;
    /**
     * Array size of hundred as integer, 100.
     */
    public static final int ARRAY_SIZE_FOR_TEST_HUNDRED = 100;
    /**
     * Array size of thousand as integer, 1000.
     */
    public static final int ARRAY_SIZE_FOR_TEST_THOUSAND = 1_000;
    /**
     * Array size of ten hundred as integer, 10,000.
     */
    public static final int ARRAY_SIZE_FOR_TEST_TEN_THOUSAND = 10_000;
    /**
     * Array size of ten thousand as integer, 100,000.
     */
    public static final int ARRAY_SIZE_FOR_TEST_HUNDRED_THOUSAND = 100_000;
    /**
     * Array size of million as integer, 1,000,000.
     */
    public static final int ARRAY_SIZE_FOR_TEST_ONE_MILL = 1_000_000;
    /**
     * Array size of ten million as integer, 10,000,000.
     */
    public static final int ARRAY_SIZE_FOR_TEST_TEN_MILL = 10_000_000;
    /**
     * Ten trials as integer, 10.
     */
    public static final int TEN_TRIALS = 10;
    /**
     * Generates a test array.
     *
     * @param testArraySize size of array to be made
     * @return test array with random integers of given size
     */
    public static int[] generateTestArrayRandomInteger(int testArraySize) {
        int[] testArray = new int[testArraySize];
        for (int j = 0; j < testArraySize; j++) {
            Random random = new Random();
            testArray[j] = random.nextInt(testArraySize);
        }
        return testArray;
    }
    /**
     * Calculates the average time of 10 quadratic sorts of an array.
     * Array is made of number of random integer of given testArraySize.
     *
     * @param testArraySize size of array to be tested
     * @return returns the average time of ten trials
     */
    public static long quadraticSortAverageTimeCalculator(int testArraySize) {
        SortTester sortTester = new SortTester();
        long totalSimulatedTimeInNanoSeconds = 0;
        for (int i = 0; i < TEN_TRIALS; i++) {
            int[] generatedTestArray = generateTestArrayRandomInteger(testArraySize);
            long simulatedTime = sortTester.quadraticSort(generatedTestArray);
            totalSimulatedTimeInNanoSeconds += simulatedTime;
        }
        return totalSimulatedTimeInNanoSeconds / TEN_TRIALS;
    }
    /**
     * Prints a helpful message about how much time has taken to do ten trials of given array size.
     *
     * @param testArraySize size of array to be tested
     * @return returns the average time of ten trials
     */
    public static long logarithmicSortAverageTimeCalculator(int testArraySize) {
        SortTester sortTester = new SortTester();
        long totalSimulatedTimeInNanoSeconds = 0;
        for (int i = 0; i < TEN_TRIALS; i++) {
            int[] generatedTestArray = generateTestArrayRandomInteger(testArraySize);
            long simulatedTime = sortTester.logarithmicSort(generatedTestArray);
            totalSimulatedTimeInNanoSeconds += simulatedTime;
        }
        return totalSimulatedTimeInNanoSeconds / TEN_TRIALS;
    }
    public static void averageTimePrinter(int testArraySize) {
        if (testArraySize >= ARRAY_SIZE_FOR_TEST_TEN_MILL) {
            System.out.println("Average time for 10 quadratic sort and "
                    + "average time for 10 logarithmic sort took more than 30 minutes");
        } else {
            long averageOfQuadraticSortTime = quadraticSortAverageTimeCalculator(testArraySize);
            long averageOfLogSortTime = logarithmicSortAverageTimeCalculator(testArraySize);
            System.out.println("printing results for array size of " + testArraySize);
            System.out.println("Average time for 10 quadratic sort took "
                    + averageOfQuadraticSortTime
                    + " nanoseconds");
            System.out.println("Average time for 10 logarithmic sort took "
                    + averageOfLogSortTime
                    + " nanoseconds\n");
        }
    }
    /**
     * Driver for sortTester.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        averageTimePrinter(ARRAY_SIZE_FOR_TEST_TEN);
        averageTimePrinter(ARRAY_SIZE_FOR_TEST_HUNDRED);
        averageTimePrinter(ARRAY_SIZE_FOR_TEST_THOUSAND);
        averageTimePrinter(ARRAY_SIZE_FOR_TEST_TEN_THOUSAND);
        averageTimePrinter(ARRAY_SIZE_FOR_TEST_HUNDRED_THOUSAND);
        averageTimePrinter(ARRAY_SIZE_FOR_TEST_ONE_MILL);
        averageTimePrinter(ARRAY_SIZE_FOR_TEST_TEN_MILL);
    }
}
