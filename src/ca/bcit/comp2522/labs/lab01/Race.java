package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

/**
 * Race.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */
public class Race {
    /**
     * Maximum random number for random generator.
     */
    public static final int MAX_NUM = 2;
    /**
     *
     */
    public static final int HALF_NUM = 1;

    private int length;
    private Hare hare;
    private Tortoise tortoise;

    /**
     * Race constructor.
     *
     * @param lengthOfRace length of a race, an int
     */
    public Race(int lengthOfRace) {
        this.length = lengthOfRace;
        this.hare = new Hare();
        this.tortoise = new Tortoise();
    }

    public int getLength() {
        return length;
    }

    public Hare getHare() {
        return this.hare;
    }

    public Tortoise getTortoise() {
        return this.tortoise;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setHare(Hare hare) {
        this.hare = hare;
    }

    public void setTortoise(Tortoise tortoise) {
        this.tortoise = tortoise;
    }

    public void reset() {
        this.hare.setPosition(0);
        this.tortoise.setPosition(0);
    }

    public String simulateRace() {
        reset();
        return race();
    }

    private String race() {
        Random random = new Random();
        Hare Hare = new Hare();
        while (true) {

            int startAnimal = random.nextInt(MAX_NUM);
            if (startAnimal == HALF_NUM) {
                this.hare.move();
                if (this.hare.getPosition() >= this.length) {
                    return "Hare";
                }
                this.tortoise.move();
                if (this.tortoise.getPosition() >= this.length) {
                    return "Tortoise";
                }
            } else {
                this.tortoise.move();
                if (this.tortoise.getPosition() >= this.length) {
                    return "Tortoise";
                }
                this.hare.move();
                if (this.hare.getPosition() >= this.length) {
                    return "Hare";
                }
            }
        }
    }
}
