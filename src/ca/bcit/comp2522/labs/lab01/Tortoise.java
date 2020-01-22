package ca.bcit.comp2522.labs.lab01;

import java.util.Objects;
import java.util.Random;

/**
 * Tortoise Class.
 * Represents a Tortoise.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class Tortoise {
    /**
     * forward.
     */
    public static final int FORWARD = 1;
    /**
     * slip.
     */
    public static final int SLIP = 6;
    /**
     * slip chance.
     */
    public static final int SLIP_CHANCE = 7;
    /**
     * fast plod.
     */
    public static final int FAST_PLOD = 3;
    /**
     * fast plod chance.
     */
    public static final int FAST_PLOD_CHANCE = 5;
    /**
     * maximum number.
     */
    public static final int MAXIMUM_NUMBER = 10;
    /**
     * start position of Tortoise.
     */
    private static final int START_POSITION = 0;
    /**
     * representation of position of Tortoise.
     */
    private int position;
    /**
     * Constructor for objects of class Tortoise.
     */
    public Tortoise() {
        this.position = START_POSITION;
    }
    /**
     * Returns the position of Tortoise created.
     *
     * @return position of Tortoise as an int
     */
    public int getPosition() {
        return position;
    }

    /**
     * Set the position of Tortoise.
     *
     * @param position the new position of Hare to be set, an int
     */
    public void setPosition(int position) {
        this.position = position;
    }

    public void move() {
        Random random = new Random();
        int movement = random.nextInt(MAXIMUM_NUMBER);
        if (movement < FAST_PLOD_CHANCE) {
            position += FAST_PLOD;
        } else if (movement < SLIP_CHANCE) {
            position -= SLIP;
        } else {
            position += FORWARD;
        }
    }

    /**
     * Returns a String representation of this Tortoise.
     *
     * @return toString a String representation
     */
    @Override
    public String toString() {
        return "Tortoise{"
                + "position=" + position
                + '}';
    }

    /**
     * Returns true if the specified object is equal to this Tortoise.
     *
     * @param o an object
     * @return true if this equals o, else false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)  {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tortoise tortoise = (Tortoise) o;

        return position == tortoise.position;
    }

    /**
     * Returns a hash code value for this Tortoise object.
     *
     * @return a hash code value of this Tortoise object
     */
    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
