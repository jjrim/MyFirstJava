package ca.bcit.comp2522.assignments.a2;

import java.util.*;


/**
 * Pool Class
 * Represents a Pool Class.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */

public class Pool {

    /**
     * Default pool temperature in celsius, 40.0.
     */
    public static final double DEFAULT_POOL_TEMP_CELSIUS = 40.0;
    public static final double MINIMUM_POOL_TEMP_CELSIUS = 0.0;
    public static final double MAXIMUM_POOL_TEMP_CELSIUS = 100.0;
    public static final double NEUTRAL_PH = 7.0;
    public static final double MAX_PH = 14.0;
    public static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.50;
    public static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;
    public static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;

    public static final int ML_TO_L = 1000;

    /**
     * Default temperature of pool.
     */
    /**
     * Default pool name of pool.
     */
    public static final String DEFAULT_POOL_NAME = "Unnamed";

    private static int numberOfPools;


    private String name;
    private double volumeLiters;
    private double temperatureCelsius;
    private double pH;
    private double nutrientCoefficient;
    private int identificationNumber;
    private ArrayList<Guppy> guppiesInPool;
    private Random randomNumberGenerator;


    public Pool() {
        this.volumeLiters = 0.0;
        this.name = DEFAULT_POOL_NAME;
        this.temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
        this.pH = NEUTRAL_PH;
        this.nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
        guppiesInPool = new ArrayList<>();
        randomNumberGenerator = new Random();
        this.identificationNumber = numberOfPools++;

    }

    public Pool(final String name,
                double volumeLiters,
                double temperatureCelsius,
                double pH,
                double nutrientCoefficient
    ) {
        if (name != null && name.trim().length() > 0) {
            String trimName = name.trim();
            this.name = formatName(trimName);
        } else {
            throw new IllegalArgumentException("Invalid form of name.");
        }
        if (Double.compare(volumeLiters, 0.0) <= 0) {
            this.volumeLiters = 0.0;
        } else {
            this.setVolumeLitres(volumeLiters);
        }
        if (MINIMUM_POOL_TEMP_CELSIUS <= temperatureCelsius
                && temperatureCelsius <= MAXIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = temperatureCelsius;
        } else {
            this.temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
        }
        if (0.0 < pH && pH < MAX_PH) {
            this.pH = pH;
        } else {
            this.pH = NEUTRAL_PH;
        }
        if (0.0 <= nutrientCoefficient && nutrientCoefficient <= 1.0) {
            this.nutrientCoefficient = nutrientCoefficient;
        } else {
            this.nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
        }
        guppiesInPool = new ArrayList<>();

        randomNumberGenerator = new Random();

        this.identificationNumber = numberOfPools++;

    }

    public String formatName(final String name) {
        return (name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase());
    }


    /**
     * get name of pool.
     *
     * @return name as string
     */
    public String getName() {
        return this.name;
    }

    /**
     * get volume of pool.
     *
     * @return volumeLitres as double
     */
    public double getVolumeLitres() {
        return this.volumeLiters;
    }
    /**
     * get temperature of pool.
     *
     * @return temperature measured in Celsius in double.
     */
    public double getTemperatureCelsius() {
        return this.temperatureCelsius;
    }

    /**
     * get ph level of pool.
     *
     * @return ph level in double
     */
    public double getPH() {
        return this.pH;
    }

    /**
     * get nutrient coefficient of pool.
     *
     * @return nutrient coefficient in double
     */
    public double getNutrientCoefficient() {
        return this.nutrientCoefficient;
    }

    /**
     * @return
     */
    public int getIdentificationNumber() {
        return this.identificationNumber;
    }

    public void setVolumeLitres(double volumeLiters) {

        if (volumeLiters > 0) {

            this.volumeLiters = volumeLiters;
        }
    }

    public void setTemperatureCelsius(double temperatureCelsius) {
        if (MINIMUM_POOL_TEMP_CELSIUS <= temperatureCelsius && temperatureCelsius <= MAXIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = temperatureCelsius;
        } else {
            this.temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
        }
    }

    public void setPH(double pH) {
        if (0.0 <= pH && pH <= MAX_PH) {
            this.pH = pH;
        }
    }

    public void setNutrientCoefficient(double nutrientCoefficient) {
        if (0.0 <= nutrientCoefficient && nutrientCoefficient <= 1.0) {
            this.nutrientCoefficient = nutrientCoefficient;
        }
    }

    public void changeNutrientCoefficient(double delta) {
        double newNutrientCoefficient = this.nutrientCoefficient + delta;
        if (newNutrientCoefficient > MAXIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = MAXIMUM_NUTRIENT_COEFFICIENT;
        } else if (newNutrientCoefficient < MINIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = MINIMUM_NUTRIENT_COEFFICIENT;
        } else {
            this.nutrientCoefficient = newNutrientCoefficient;
        }
    }

    /**
     * changes temperature of pool.
     * if it the temperature of pool decreases under the minimum possible temperature, set it to minimum temperature.
     * if it the temperature of pool increases above the maximum possible temperature, set it to maximum temperature
     *
     * @param
     */
    public void changeTemperature(double delta) {
        double newTemperatureCelsius = this.temperatureCelsius + delta;
        if (newTemperatureCelsius > MAXIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = MAXIMUM_POOL_TEMP_CELSIUS;
        } else if (newTemperatureCelsius < MINIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = MINIMUM_POOL_TEMP_CELSIUS;
        } else {
            this.temperatureCelsius = newTemperatureCelsius;
        }
    }

    /**
     * get number of total pools created.
     *
     * @return number of pools in integer
     */
    public static int getNumberCreated() {
        return numberOfPools;
    }

    public boolean addGuppy(Guppy guppy) {
        if (guppy == null) {
            return false;
        } else {
            this.guppiesInPool.add(guppy);
            return true;
        }
    }

    public int getPopulation() {
        int population = 0;
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive()) {
                population++;
            }
        }
        return population;
    }

    public int applyNutrientCoefficient() {
        int deadGuppies = 0;
        for (Guppy guppy : this.guppiesInPool) {
            if (randomNumberGenerator.nextDouble() > getNutrientCoefficient()) {
                guppy.setIsAlive(false);
                deadGuppies++;
            }
        }
        return deadGuppies;
    }

    public int removeDeadGuppies() {
        int removedDeadGuppies = 0;
        Iterator<Guppy> it = guppiesInPool.iterator();

        while (it.hasNext()) {
            Guppy currentGuppy = it.next();
            if (!currentGuppy.getIsAlive()) {
                it.remove();
                ++removedDeadGuppies;

            }
        }
        return removedDeadGuppies;
    }

    public double getGuppyVolumeRequirementInLitres() {
        double totalVolumeInML = 0;
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive()) {
                totalVolumeInML += guppy.getVolumeNeeded();
            }
        }
        return totalVolumeInML / ML_TO_L;
    }

    /**
     * get average age in weeks of alive guppies in pool.
     *
     * @return average age in weeks, a double
     */
    public double getAverageAgeInWeeks() {
        double totalAgeInWeeks = 0.0;
        if (!guppiesInPool.isEmpty()) {
            for (Guppy guppy : guppiesInPool) {
                if (guppy.getIsAlive()) {
                    totalAgeInWeeks += guppy.getAgeInWeeks();
                }
            }
            return totalAgeInWeeks / guppiesInPool.size();
        } else {
            return totalAgeInWeeks;
        }

    }

    /**
     *
     * @return averageHealthCoefficient
     */
    public double getAverageHealthCoefficient() {
        double totalHealthCoefficient = 0.0;
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive()) {
                totalHealthCoefficient += guppy.getHealthCoefficient();
            }
        }
        return totalHealthCoefficient / guppiesInPool.size();
    }

    /**
     * get percentage of female guppies in pool.
     *
     * @return percentage of female guppies, a double
     */
    public double getFemalePercentage() {
        double femaleGuppiesTotal = 0;
        if (!guppiesInPool.isEmpty()) {
            for (Guppy guppy : guppiesInPool) {
                if (guppy.getIsFemale()) {
                    ++femaleGuppiesTotal;
                }
            }
            return femaleGuppiesTotal / guppiesInPool.size();
        }
        return femaleGuppiesTotal;
    }


    /**
     * Order Guppies from youngest to oldest and get the median age of guppies.
     *
     * @return median age of guppy, a double
     */
    public double getMedianAge() {
        ArrayList<Integer> listOfAges = new ArrayList<>();
        for (Guppy guppy : guppiesInPool) {
            if (!guppiesInPool.isEmpty()) {
                listOfAges.add(guppy.getAgeInWeeks());
            }
        }

        if (!listOfAges.isEmpty()) {
            Collections.sort(listOfAges);
            int rightCount = listOfAges.size() - 1;
            int leftCount = 0;

            while (rightCount > leftCount) {
                --rightCount;
                ++leftCount;

                if (rightCount == leftCount) {
                    return listOfAges.get(leftCount);
                }
            }
            double medianAge = (listOfAges.get(leftCount) + listOfAges.get(rightCount) / 2.0);
            System.out.println("medianAge: " + medianAge);
            return medianAge;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "Pool{"
                +
                "DEFAULT_POOL_NAME='"
                + DEFAULT_POOL_NAME
                + '\''
                +
                ", DEFAULT_POOL_TEMP_CELSIUS="
                + DEFAULT_POOL_TEMP_CELSIUS
                +
                ", MINIMUM_POOL_TEMP_CELSIUS="
                + MINIMUM_POOL_TEMP_CELSIUS
                +
                ", MAXIMUM_POOL_TEMP_CELSIUS="
                + MAXIMUM_POOL_TEMP_CELSIUS
                +
                ", NEUTRAL_PH="
                + NEUTRAL_PH
                +
                ", DEFAULT_NUTRIENT_COEFFICIENT="
                + DEFAULT_NUTRIENT_COEFFICIENT
                +
                ", MINIMUM_NUTRIENT_COEFFICIENT="
                + MINIMUM_NUTRIENT_COEFFICIENT
                +
                ", MAXIMUM_NUTRIENT_COEFFICIENT="
                + MAXIMUM_NUTRIENT_COEFFICIENT
                +
                ", ML_to_L="
                + ML_TO_L
                +
                ", name='" + name + '\''
                +
                ", volumeLiters=" + volumeLiters
                +
                ", temperatureCelsius="
                + temperatureCelsius
                +
                ", pH="
                + pH
                +
                ", nutrientCoefficient="
                + nutrientCoefficient
                +
                ", identificationNumber="
                + identificationNumber
                +
                ", guppiesInPool="
                + guppiesInPool
                +
                ", randomNumberGenerator="
                + randomNumberGenerator
                +
                '}';
    }

    /**
     * Spawns new guppies in pool and counts the total number of guppies in pool.
     *
     * @return total number of guppies in pool.
     */
    public int spawn() {
        int numberOfNewBornFry = 0;
        ArrayList<Guppy> newGuppy = new ArrayList<>();

        for (Guppy guppy : guppiesInPool) {
            ArrayList<Guppy> fry = guppy.spawn();
            if (fry != null && !fry.isEmpty()) {
                newGuppy.addAll(fry);
                numberOfNewBornFry += fry.size();
            }
        }
        guppiesInPool.addAll(newGuppy);

//        System.out.println("numberOfNewBornFry: " + numberOfNewBornFry);

        return numberOfNewBornFry;
    }

    /**
     * Increments age of guppies in pool and counts the dead guppies because of old age.
     *
     * @return dead guppies because of age, int
     */
    public int incrementAges() {
        int numberOfDeadOldGuppies = 0;

        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive()) {
                guppy.incrementAge();
                if (!guppy.getIsAlive()) {
                    ++numberOfDeadOldGuppies;
                }
            }
        }

//        System.out.println("numberOfDeadGuppies: " + numberOfDeadGuppies);

        return numberOfDeadOldGuppies;
    }

    /**
     * Extinguishes Guppies of lower health coefficient when pool gets overcrowded.
     * Overcrowded means having more Guppies than maximum volume of water per Guppies.
     *
     * @return number of died Guppies due to overcrowding, an int
     */
    public int adjustForCrowding() {
        int numberOfDeadOverCrowdedGuppies = 0;
        guppiesInPool.sort(Comparator.comparingDouble(Guppy::getHealthCoefficient));
        for (Guppy guppy : guppiesInPool) {
            if (getGuppyVolumeRequirementInLitres() > getVolumeLitres()) {
                guppy.setIsAlive(false);
                numberOfDeadOverCrowdedGuppies++;
            }
        }
        //        System.out.println("numberOfDeadOverCrowdedGuppies: "
        //        + numberOfDeadOverCrowdedGuppies);

        return numberOfDeadOverCrowdedGuppies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pool pool = (Pool) o;
        return Double.compare(pool.volumeLiters, volumeLiters) == 0
                &&
                Double.compare(pool.temperatureCelsius, temperatureCelsius) == 0
                &&
                Double.compare(pool.pH, pH) == 0
                &&
                Double.compare(pool.nutrientCoefficient, nutrientCoefficient) == 0
                &&
                identificationNumber == pool.identificationNumber
                &&
                Objects.equals(name, pool.name)
                &&
                Objects.equals(guppiesInPool, pool.guppiesInPool)
                &&
                Objects.equals(randomNumberGenerator, pool.randomNumberGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,
                volumeLiters,
                temperatureCelsius,
                pH,
                nutrientCoefficient,
                identificationNumber,
                guppiesInPool,
                randomNumberGenerator);
    }
}


