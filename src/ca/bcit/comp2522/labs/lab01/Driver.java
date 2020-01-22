package ca.bcit.comp2522.labs.lab01;

/**
 * Driver class for Hare and Tortoise.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class Driver {
    /**
     * number of race to be stimulated.
     */
    public static final int NUMBER_OF_RACE = 100;
    /**
     * race length of hundred.
     */
    public static final int RACE_LENGTH_OF_HUNDRED = 100;
    /**
     * race length of thousand.
     */
    public static final int RACE_LENGTH_OF_THOUSAND = 1000;



    public static void main(String[] args) {
        System.out.println(simulateRaces(NUMBER_OF_RACE, RACE_LENGTH_OF_HUNDRED));
        System.out.println(simulateRaces(NUMBER_OF_RACE, RACE_LENGTH_OF_THOUSAND));
    }

    public static String simulateRaces(int numberOfRace, int lengthOfRace) {
        int hareCount = 0;
        int tortoiseCount = 0;
        Race game = new Race(lengthOfRace);
        for (int i = 0; i < numberOfRace; i++) {
            if (game.simulateRace().equals("Hare")) {
                hareCount++;
            } else {
                tortoiseCount++;
            }
        }

            if (hareCount > tortoiseCount) {
                return "The winner is Hare!" + hareCount;
            } else {
                return "The winner is Tortoise!" + tortoiseCount;
            }
        }
    }
