package ca.bcit.comp2522.labs.lab01;

import java.util.Objects;
import java.util.Random;

/**
 * Hare Class.
 * Represents a Hare.
 *
 * @author Jay Rim A01174716
 * @version 2020.01
 */
public class Hare {
    /**
     * Chance to do a small hop.
     */
    public static final int SMALL_HOP_CHANCE = 7;
    /**
     * Chance to do a big slip.
     */
    public static final int BIG_SLIP_CHANCE = 3;
    /**
     * Chance to do a big hop.
     */
    public static final int BIG_HOP_CHANCE = 2;
    /**
     * Big hop of a hare in a race.
     */
    public static final int BIG_HOP = 9;
    /**
     * Big slip of a hare in a race.
     */
    public static final int BIG_SLIP = 12;
    /**
     * Small hop of a hare in a race.
     */
    public static final int SMALL_HOP = 1;
    /**
     * Small slip of a hare in a race.
     */
    public static final int SMALL_SLIP = 2;
    /**
     * The initial position of Hare.
     */
    public static final int START_POSITION = 0;
    /**
     * Position of Hare.
     */
    public static final int MAXIMUM_NUMBER = 10;

    private int position;

    /**
     * Hare constructor.
     *
     * Constructs a hare class with hares position at the start of the race.
     */
    public Hare() {
        this.position = START_POSITION;
    }

    /**
     * Gets Hare's current position.
     *
     * @return position for Hare
     */
    public int getPosition() {
        return position;
    }

    /**
     * Set the position of Hare.
     * @param position the new position of Hare to be set, an int
     */
    public void setPosition(int position) {
        this.position = position;
    }

    public int move() {
        Random random = new Random();
        int moveProbability = random.nextInt(MAXIMUM_NUMBER);
        if (moveProbability < BIG_HOP_CHANCE) {
            position = START_POSITION;
        } else if (moveProbability == BIG_HOP_CHANCE) {
            position = position + BIG_HOP;
        } else if (moveProbability == BIG_SLIP_CHANCE) {
            position = position - BIG_SLIP;
        } else if (moveProbability < SMALL_HOP_CHANCE) {
            position = position + SMALL_HOP;
        } else {
            position = position - SMALL_SLIP;
        }
        return position;
    }

    /**
     * Returns a String representation of this Hare.
     *
     * @return toString a String representation
     */
    @Override
    public String toString() {
        return "Hare{"
                + "position=" + position
                + '}';
    }

    /**
     * Returns true if the specified object is equal to this Hare.
     *
     * @param o an object
     * @return true if this equals o, else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hare hare = (Hare) o;

        return position == hare.position;
    }

    /**
     * Returns a hash code value for this Hare object.
     *
     * @return a hash code value of this Hare object
     */
    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
