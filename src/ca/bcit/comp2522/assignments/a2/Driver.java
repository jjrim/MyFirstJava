package ca.bcit.comp2522.assignments.a2;

import java.util.Scanner;

/**
 * Driver
 *
 * @author Jay Rim A01174716
 * @version 2020
 */

public class Driver {
    public static void main(String[] args) {
        Ecosystem ecosystem = new Ecosystem();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of weeks: ");
        int numberOfWeeks = scanner.nextInt();
        System.out.println("Number of weeks entered is: " + numberOfWeeks);
        ecosystem.simulate(numberOfWeeks);
    }
}


