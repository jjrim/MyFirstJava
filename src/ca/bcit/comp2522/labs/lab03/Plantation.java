package ca.bcit.comp2522.labs.lab03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Plantation Class.
 *
 * @author Jay Rim A01174716
 * @version 2020
 */

public class Plantation {
    private static final int MAX_RANDOM_TREE_BOUND = 990;
    private static final int MINIMUM_BOUND = 10;
    private static final int MAX_CIRCUMFERENCE = 91;
    private static final int MAX_AGE = 1000;

    private ArrayList<Tree> farm;
    private ArrayList<Tree> harvestedTrees;

    public Plantation() {
        this.farm = new ArrayList<Tree>();
    }

    public int size() {
        return farm.size();
    }



    public int add(final Tree tree) {
        if (tree == null) {
            throw new NullPointerException("Null value can not be accepted.");
        } else {
            farm.add(tree);
        }
        return farm.size();
    }

    public int seed() {
        Random random = new Random();
        int numberOfTreesToPlant = random.nextInt(MAX_RANDOM_TREE_BOUND + 1) + MINIMUM_BOUND;
        for (int i = 0; i < numberOfTreesToPlant; i++) {
            int randomAge = random.nextInt(MAX_AGE + 1);
            int randomCircumference = random.nextInt(MAX_CIRCUMFERENCE) + MINIMUM_BOUND;
            int randomSpeciesNumber = random.nextInt(Tree.Species.values().length);
            Tree.Species randomSpecies = Tree.Species.values()[randomSpeciesNumber];
            Tree newTree = new Tree(randomAge, randomCircumference, randomSpecies);
            this.add(newTree);
        }
        return numberOfTreesToPlant;
    }

    public ArrayList<Tree> harvestCount(double cutOffCircumference) {
        harvestedTrees = new ArrayList<>();
        Iterator<Tree> it = farm.iterator();
        while (it.hasNext()) {
            Tree currentTree = it.next();
            double currentCircumference = currentTree.getTrunkCircumferenceInCm();
            if ((Double.compare(currentCircumference, cutOffCircumference) == 0)
                    || (Double.compare(currentCircumference, cutOffCircumference) > 0)) {
                harvestedTrees.add(currentTree);
                it.remove();
            }
        }
        return harvestedTrees;
    }
}
