package ca.bcit.comp2522.labs.lab09;

/**
 * Represents SortTester class.
 * https://stackabuse.com/sorting-algorithms-in-java/#insertionsort (insertion sort)
 * https://www.geeksforgeeks.org/iterative-merge-sort/ (merge sort)
 *
 * @author Jay Rim
 * @version 2020
 */
public class SortTester {
    /**
     * Sorts an array of integer with insertion sort.
     *
     * @param array Array of integer to sort with insertion sort function.
     * @return total time consumed to insertion sort function
     */
    long quadraticSort(int[] array) {
        long startTime = System.nanoTime();
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    /**
     * Sorts an array of integer with merge sort.
     *
     * @param array Array of integer to sort with merge sort function.
     * @return total time consumed to perform merge sort function
     */
    long logarithmicSort(int[] array) {
        long startTime = System.nanoTime();
        if (array != null && array.length > 1) {
            int mid = array.length / 2;
            int[] left = new int[mid];
            for (int i = 0; i < mid; i++) {
                left[i] = array[i];
            }
            int[] right = new int[array.length - mid];
            for (int i = mid; i < array.length; i++) {
                right[i - mid] = array[i];
            }
            logarithmicSort(left);
            logarithmicSort(right);
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    array[k] = left[i];
                    i++;
                } else {
                    array[k] = right[j];
                    j++;
                }
                k++;
            }
            while (i < left.length) {
                array[k] = left[i];
                i++;
                k++;
            }
            while (j < right.length) {
                array[k] = right[j];
                j++;
                k++;
            }
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
