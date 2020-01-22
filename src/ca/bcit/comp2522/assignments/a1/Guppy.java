package ca.bcit.comp2522.assignments.a1;

import java.util.Objects;

/**
 * Guppy Class
 * Represents a Guppy Class.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */

public class Guppy {
    /**
     * Young Guppy age in weeks, 10.
     */
    public static final int YOUNG_FISH_AGE_IN_WEEKS = 10;

    /**
     * Mature Guppy age in weeks, 30.
     */
    public static final int MATURE_FISH_AGE_IN_WEEKS = 30;

    /**
     * Maximum Guppy age in weeks, 50.
     */
    public static final int MAXIMUM_AGE_IN_WEEKS = 50;

    /**
     * Minimum volume of water for Guppy in ml, 250.0.
     */
    public static final double MINIMUM_WATER_VOLUME_ML = 250.0;

    /**
     * Default genus of Guppy, "Poecilia".
     */
    public static final String DEFAULT_GENUS = "Poecilia";

    /**
     * Default species of Guppy, "reticulata".
     */
    public static final String DEFAULT_SPECIES = "reticulata";

    /**
     * Default health coefficient, 0.5.
     */
    public static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;

    /**
     * Minimum health coefficient, 0.0.
     */
    public static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;

    /**
     * Maximum health coefficient, 1.0.
     */
    public static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;

    private static int numberOfGuppiesBorn; //tracker for guppy

    private String genus;
    private String species;
    private int ageInWeeks;
    private boolean isFemale;
    private int generationNumber;
    private boolean isAlive;
    private double healthCoefficient;
    private int identificationNumber;

    /**
     * Guppy object constructor.
     */
    public Guppy() {
        this.genus = DEFAULT_GENUS;
        this.species = DEFAULT_SPECIES;
        this.isFemale = true;
        this.isAlive = true;
        this.healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
        this.identificationNumber = ++numberOfGuppiesBorn;
    }

    /**
     * Multi-parameter constructor for objects of Guppy class.
     *
     * @param newGenus             a String to set genus, it can not be null or empty
     * @param newSpecies           a String to set species, if can not be null or empty
     * @param newAgeInWeeks        integer value for age in weeks
     * @param newIsFemale          true if female, else false
     * @param newGenerationNumber  must be positive
     * @param newHealthCoefficient must be between MINIMUM_HEALTH_COEFFICIENT
     *                             and MAXIMUM_HEALTH_COEFFICIENT
     */

    public Guppy(final String newGenus,
                 final String newSpecies,
                 int newAgeInWeeks,
                 boolean newIsFemale,
                 int newGenerationNumber,
                 double newHealthCoefficient) {
        if (newGenus != null && newGenus.trim().length() > 0) {
            this.genus = formatNameTitle(newGenus.trim());
        } else {
            throw new IllegalArgumentException("Genus cannot be empty!");
        }

        if (newSpecies != null && newSpecies.trim().length() > 0) {
            this.species = newSpecies.trim().toLowerCase();
        } else {
            throw new IllegalArgumentException("Species cannot be empty!");
        }


        if (newAgeInWeeks < 0) {
            throw new IllegalArgumentException("Incorrect Age!");
        } else {
            this.ageInWeeks = newAgeInWeeks;
        }

        this.isFemale = newIsFemale;

        if (newGenerationNumber < 0 || newAgeInWeeks >= MAXIMUM_AGE_IN_WEEKS) {
            throw new IllegalArgumentException("Generation must be positive!");
        } else {
            this.generationNumber = newGenerationNumber;
        }

        if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT
                || newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            throw new IllegalArgumentException("Health coefficient must be in range!");
        } else {
            this.healthCoefficient = newHealthCoefficient;
        }

        this.isAlive = true;
        this.identificationNumber = ++numberOfGuppiesBorn;

    }

    /**
     * Increments age of Guppy by 1 week. If ageInWeeks by getAgeInWeeks() method is bigger
     * than MAXIMUM_AGE_IN_WEEKS, isAlive() will be false.
     */
    public void incrementAge() {
        if (isAlive) {
            ++this.ageInWeeks;
        }
        if (getAgeInWeeks() > MAXIMUM_AGE_IN_WEEKS) {
            setIsAlive(false);
        }
    }

    /**
     * Returns genus.
     *
     * @return genus as a String.
     */
    public String getGenus() {
        return genus;
    }

    /**
     * Returns genus of Guppy.
     *
     * @return genus as a String
     */

    public String getSpecies() {
        return species;
    }

    /**
     * Returns age in weeks of Guppy.
     *
     * @return ageInWeek as an integer
     */
    public int getAgeInWeeks() {
        return ageInWeeks;
    }

    /**
     * Returns true if Guppy is female, else false.
     *
     * @return isFemale as a boolean
     */
    public boolean getIsFemale() {
        return isFemale;
    }

    /**
     * Returns generation number of Guppy.
     *
     * @return generationNumber as integer
     */
    public int getGenerationNumber() {
        return generationNumber;
    }

    /**
     * Returns true if Guppy is alive, else false.
     *
     * @return isAlive as a boolean
     */
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * Returns health coefficient of a Guppy.
     *
     * @return healthCoefficient as a double
     */
    public double getHealthCoefficient() {
        return healthCoefficient;
    }

    /**
     * Returns identification number of a Guppy.
     *
     * @return identificationNumber as an integer
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Returns the number of Guppies born.
     *
     * @return number of Guppies as an integer
     */
    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }

    /**
     * set a new age in weeks if it is bigger or equal to 0 or smaller or equal to
     * MAXIMUM_AGE_IN_WEEKS.
     *
     * @param newAgeInWeeks newAgeInWeeks to set
     */
    public void setAgeInWeeks(int newAgeInWeeks) {
        if (newAgeInWeeks >= 0 && newAgeInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            this.ageInWeeks = newAgeInWeeks;
        }
    }

    /**
     * Sets whether the Guppy is alive.
     *
     * @param newIsAlive true if alive, otherwise false
     */
    public void setIsAlive(boolean newIsAlive) {
        this.isAlive = newIsAlive;
    }

    /**
     * Sets a new health coefficient within MINIMUM_HEALTH_COEFFICIENT
     * and MAXIMUM_HEALTH_COEFFICIENT.
     *
     * @param newHealthCoefficient new healthCoefficient to set, a double
     */
    public void setHealthCoefficient(double newHealthCoefficient) {
        if (newHealthCoefficient >= MINIMUM_HEALTH_COEFFICIENT
                && newHealthCoefficient <= MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = newHealthCoefficient;
        }
    }

    /**
     * Returns volume of water needed by guppy depending on their age.
     *
     * @return needed volume in mL, in double
     */
    public double getVolumeNeeded() {
        if (getAgeInWeeks() < YOUNG_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML;
        } else if (getAgeInWeeks() <= MATURE_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * ageInWeeks / YOUNG_FISH_AGE_IN_WEEKS;
        } else if (getAgeInWeeks() <= MAXIMUM_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML
                    * (DEFAULT_HEALTH_COEFFICIENT + MAXIMUM_HEALTH_COEFFICIENT);
        } else {
            return MINIMUM_HEALTH_COEFFICIENT;
        }
    }

    /**
     * Changes the health coefficient with a new given health coefficient.
     * The health coefficient is within the bound [0.0, 1.0]
     *
     * @param delta a double
     */
    public void changeHealthCoefficient(double delta) {
        double newHealthCoefficient = healthCoefficient + delta;
        if (newHealthCoefficient <= MINIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = MINIMUM_HEALTH_COEFFICIENT;
            setIsAlive(false);
        } else if (newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        } else {
            setHealthCoefficient(newHealthCoefficient);
        }
    }

    /**
     * Formats the first letter of a name to uppercase and rest of the string to lower case.
     * If null is passed, null is returned.
     *
     * @param name the name to format
     * @return the correctly formatted name, as a String
     */
    private static String formatNameTitle(String name) {
        if (name != null && name.trim().length() > 0) {
            String firstLetter = name.trim().toUpperCase().substring(0, 1);
            String theRest = name.trim().toLowerCase().substring(1);
            return firstLetter + theRest;
        } else {
            return null;
        }
    }

    /**
     * String representation of Guppy.
     *
     * @return toString a String representation
     */
    @Override
    public String toString() {
        return "Guppy{"
                + "genus='" + genus + '\''
                + ", species='" + species + '\''
                + ", ageInWeeks=" + ageInWeeks
                + ", isFemale=" + isFemale
                + ", generationNumber=" + generationNumber
                + ", isAlive=" + isAlive
                + ", healthCoefficient=" + healthCoefficient
                + ", identificationNumber=" + identificationNumber
                + '}';
    }

    /**
     * Returns true if the specified object is equal to Guppy.
     *
     * @param o an object
     * @return true if equals object o, else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Guppy guppy = (Guppy) o;
        return ageInWeeks == guppy.ageInWeeks
                && isFemale == guppy.isFemale
                && generationNumber == guppy.generationNumber
                && isAlive == guppy.isAlive
                && Double.compare(guppy.healthCoefficient, healthCoefficient) == 0
                && identificationNumber == guppy.identificationNumber
                && genus.equals(guppy.genus)
                && species.equals(guppy.species);
    }

    /**
     * Returns a hash code value for Guppy.
     *
     * @return a hash code value of Guppy
     */
    @Override
    public int hashCode() {
        return Objects.hash(genus, species, ageInWeeks, isFemale, generationNumber, isAlive,
                healthCoefficient, identificationNumber);
    }
}
