package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Random;


/**
 * Ecosystem Class
 * Represents a Ecosystem Class.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */

public class Ecosystem {

    /**
     * Skookumchuk pool volume, 3000.
     */
    public static final double SKOOKUMCHUK_POOL_VOLUME = 3000;
    /**
     * Squamish pool volume, 15000.
     */
    public static final double SQUAMISH_POOL_VOLUME = 15000;
    /**
     * Semiahmoo pool volume, 4500.
     */
    public static final double SEMIAHMOO_POOL_VOLUME = 4500;
    /**
     * Number of Guppies in Skookumchuk pool.
     */
    public static final double SKOOKUMCHUK_GUPPIES = 300;
    /**
     * Number of Guppies in Squamish pool.
     */
    public static final double SQUAMISH_GUPPIES = 100;
    /**
     * Number of Guppies in Semiahmoo pool.
     */
    public static final double SEMIAHMOO_GUPPIES = 200;
    /**
     * Temperature of Skookumchuk pool.
     */
    public static final double SKOOKUMCHUK_TEMP = 42;
    /**
     * Temperature of Squamish pool.
     */
    public static final double SQUAMISH_TEMP = 39;
    /**
     * Temperature of Semiahmoo pool.
     */
    public static final double SEMIAHMOO_TEMP = 37;
    /**
     * PH of Skookumchuk pool.
     */
    public static final double SKOOKUMCHUK_PH = 7.9;
    /**
     * PH of Squamish pool.
     */
    public static final double SQUAMISH_PH = 7.7;
    /**
     * PH of Semiahmoo pool.
     */
    public static final double SEMIAHMOO_PH = 7.5;
    /**
     * Nutrient coefficient value of Skookumchuk pool.
     */
    public static final double SKOOKUMCHUK_NUTRIENT_VAL = 0.9;
    /**
     * Nutrient coefficient value of Skookumchuk pool.
     */
    public static final double SQUAMISH_NUTRIENT_VAL = 0.85;
    /**
     * 75% chance of being guppy being female, a double.
     */
    public static final double FEMALE_CHANCE_75_PERCENT  = 0.75;
    /**
     * 35% chance of being guppy being female, a double.
     */
    public static final double FEMALE_CHANCE_35_PERCENT  = 0.35;
    /**
     * 0.2 nutrient coefficient value for random.
     */
    public static final double RANDOM_DOUBLE_RANGE_COEFFICIENT_ZERO_POINT_TWO = 0.2;
    /**
     * 0.3 nutrient coefficient value for random.
     */
    public static final double RANDOM_DOUBLE_RANGE_COEFFICIENT_ZERO_POINT_THREE = 0.3;
    /**
     * 0.4 nutrient coefficient value for random.
     */
    public static final double RANDOM_DOUBLE_RANGE_COEFFICIENT_ZERO_POINT_FOUR = 0.4;
    /**
     * 0.8 nutrient coefficient value for random.
     */
    public static final double RANDOM_DOUBLE_RANGE_COEFFICIENT_ZERO_POINT_EIGHT = 0.8;
    /**
     * Number 10 for random integer.
     */
    public static final int RANDOM_INT_RANGE_10 = 10;
    /**
     * Number 16 for random integer.
     */
    public static final int RANDOM_INT_RANGE_16 = 16;
    /**
     * Number 6 for random integer.
     */
    public static final int RANDOM_INT_RANGE_6 = 6;
    /**
     * Number 15 for random integer.
     */
    public static final int RANDOM_INT_RANGE_15 = 15;
    /**
     * Number 35 for random integer.
     */
    public static final int RANDOM_INT_RANGE_35 = 35;








    private ArrayList<Pool> pools;

    public Ecosystem() {
        this.pools = new ArrayList<>();
    }

    public void addPool(Pool newPool) {
        if (newPool != null) {
            pools.add(newPool);
        }
    }


    /**
     * Clears pools.
     *
     */
    public void reset() {
        pools.clear();
    }

    /**
     * get the total population of guppies in pools.
     *
     * @return total number of guppies, an int
     */
    public int getGuppyPopulation() {
        int guppyTotalPopulation = 0;
        for (Pool pool : pools) {
            guppyTotalPopulation += pool.getPopulation();
        }
        return guppyTotalPopulation;
    }


    /**
     * Adjust number of guppies if the pools get too crowded.
     *
     * @return number of dead guppies from pool, an int
     */
    public int adjustForCrowding() {
        int numberOfDeadGuppies = 0;
        for (Pool pool: pools) {
            numberOfDeadGuppies += pool.adjustForCrowding();
        }
        return numberOfDeadGuppies;
    }

    /**
     * Sets up simulation environments.
     */
    public void setupSimulation() {
        Pool skookumchuk = new Pool(
                "Skookumchuk",
                SKOOKUMCHUK_POOL_VOLUME,
                SKOOKUMCHUK_TEMP,
                SKOOKUMCHUK_PH,
                SKOOKUMCHUK_NUTRIENT_VAL);
        Pool squamish = new Pool(
                "Squamish",
                SQUAMISH_POOL_VOLUME,
                SQUAMISH_TEMP,
                SQUAMISH_PH,
                SQUAMISH_NUTRIENT_VAL);
        Pool semiahmoo = new Pool(
                "Semiahmoo",
                SEMIAHMOO_POOL_VOLUME,
                SEMIAHMOO_TEMP,
                SEMIAHMOO_PH,
                1.0);

        this.addPool(skookumchuk);
        this.addPool(squamish);
        this.addPool(semiahmoo);

        Random random = new Random();


        for (int i = 0; i < SKOOKUMCHUK_GUPPIES; ++i) {
            int skookumchukPoolRandom = random.nextInt(RANDOM_INT_RANGE_16) + RANDOM_INT_RANGE_10;
            boolean random75chance = (random.nextDouble() < FEMALE_CHANCE_75_PERCENT);
            double randomHealthCoefficientPool1 = random.nextDouble()
                    * RANDOM_DOUBLE_RANGE_COEFFICIENT_ZERO_POINT_THREE
                    + RANDOM_DOUBLE_RANGE_COEFFICIENT_ZERO_POINT_FOUR;
            Guppy guppy = new Guppy("Poecilia", "reticulata",
                    skookumchukPoolRandom, random75chance,
                    1, randomHealthCoefficientPool1);
            skookumchuk.addGuppy(guppy);
        }

        for (int i = 0; i < SQUAMISH_GUPPIES; ++i) {
            int squamishPoolRandom = random.nextInt(RANDOM_INT_RANGE_6) + RANDOM_INT_RANGE_10;
            boolean random75chance = (random.nextDouble() < FEMALE_CHANCE_75_PERCENT);
            double squamishPoolCoefficent = random.nextDouble()
                    * RANDOM_DOUBLE_RANGE_COEFFICIENT_ZERO_POINT_TWO
                    + RANDOM_DOUBLE_RANGE_COEFFICIENT_ZERO_POINT_EIGHT;
            Guppy guppy = new Guppy("Poecilia", "reticulata",
                    squamishPoolRandom, random75chance,
                    1, squamishPoolCoefficent);
            squamish.addGuppy(guppy);
        }

        for (int i = 0; i < SEMIAHMOO_GUPPIES; ++i) {
            int semiahmooPoolRandom = random.nextInt(RANDOM_INT_RANGE_35) + RANDOM_INT_RANGE_15;
            boolean random35PercentChance = (random.nextDouble() < FEMALE_CHANCE_35_PERCENT);
            double semiahmooPoolCoefficient = random.nextDouble();
            Guppy guppy = new Guppy("Poecilia", "reticulata",
                    semiahmooPoolRandom, random35PercentChance,
                    1, semiahmooPoolCoefficient);
            semiahmoo.addGuppy(guppy);
        }
    }


    /**
     * Simulates pool by number of weeks in the driver function.
     *
     * @param numberOfWeeks number of weeks, an int
     */
    public void simulate(int numberOfWeeks) {
        setupSimulation();
        for (int i = 0; i < numberOfWeeks; i++) {
            simulateOneWeek(i + 1);
        }
        this.reset();
    }

    /**
     * Simulate pool by one week and print out the results.
     *
     * @param weekNumber number of weeks to simulate, an int
     */
    public void simulateOneWeek(int weekNumber) {
        int diedOfOldAge = 0;
        int numberRemoved = 0;
        int starvedToDeath = 0;
        int newFry = 0;
        int crowdedOut = 0;

        for (Pool pool: pools) {
            diedOfOldAge += pool.incrementAges();
            numberRemoved += pool.removeDeadGuppies();
            starvedToDeath += pool.applyNutrientCoefficient();
            numberRemoved += pool.removeDeadGuppies();
            newFry += pool.spawn();
            crowdedOut += pool.adjustForCrowding();
        }

        for (Pool pool: pools) {
            numberRemoved += pool.removeDeadGuppies();
        }

        int skookumchukGuppies = pools.get(0).getPopulation();
        int squamishGuppies = pools.get(1).getPopulation();
        int semiahmooGuppies = pools.get(2).getPopulation();
        int totalGuppies = skookumchukGuppies + squamishGuppies + semiahmooGuppies;

        if (diedOfOldAge + starvedToDeath + crowdedOut != numberRemoved) {
            throw new Error("There is a logical error. Please review your codes.");
        }

        if (diedOfOldAge + starvedToDeath + crowdedOut == numberRemoved) {
            System.out.println("WEEK: " + weekNumber);
            System.out.println("DEATH DUE TO OLD AGE: " + diedOfOldAge);
            System.out.println("DEATH DUE TO STARVATION: " + starvedToDeath);
            System.out.println("DEATH DUE TO OVERCROWDING: " + crowdedOut);
            System.out.println("THIS WEEK NEW FRY : " + newFry);
            System.out.println("Skookumchuk : " + skookumchukGuppies);
            System.out.println("Squamish : " + squamishGuppies);
            System.out.println("Semiahmoo : " + semiahmooGuppies);
            System.out.println("total : " + totalGuppies);
            System.out.println("----------------------------------------------------------");

        }
    }
}
