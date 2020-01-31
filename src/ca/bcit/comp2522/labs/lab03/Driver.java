package ca.bcit.comp2522.labs.lab03;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Driver Class.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class Driver {

    private static ArrayList<Tree> harvestedTrees;

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Choose a circumference to cut: ");
        double circumferenceLimit = myObj.nextDouble();


        int numberOfTreesPlanted = 0;
        Plantation lotusLandLumber = new Plantation();
        int numberOfPlantationRepetition = 5;
        for (int i = 0; i < numberOfPlantationRepetition; i++) {
            numberOfTreesPlanted += lotusLandLumber.seed();
        }

        System.out.println("The number of trees planted of 5 plantations: " + numberOfTreesPlanted);

        harvestedTrees = lotusLandLumber.harvestCount(circumferenceLimit);
        System.out.println("Harvesting circumference limit is: " + circumferenceLimit);

        System.out.println("The number of trees harvested: " + harvestedTrees.size());
    }
}
