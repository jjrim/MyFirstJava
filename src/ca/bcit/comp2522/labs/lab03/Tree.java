package ca.bcit.comp2522.labs.lab03;


import java.util.Objects;

public class Tree {
    public static final int MINIMUM_AGE = 0;
    public static final int MINIMUM_CIRCUMFERENCE = 0;
    public enum Species {
        MAPLE,
        ARBUTUS,
        BLUE_SPRUCE
    }
    private Species typeOfTree;
    private int ageInYears;
    private double trunkCircumferenceInCM;
    public Tree(int ageInYears, double trunkCircumferenceInCM, final Species species) {
        if (ageInYears >= MINIMUM_AGE) {
            this.ageInYears = ageInYears;
        }
        if (trunkCircumferenceInCM > MINIMUM_CIRCUMFERENCE) {
            this.trunkCircumferenceInCM = trunkCircumferenceInCM;
        }
        this.typeOfTree = species;
    }
    public Tree(int ageInYears, double trunkCircumferenceInCm) { // fix this
        this(ageInYears, trunkCircumferenceInCm, Species.MAPLE);
    }
    public int getAgeInYears() {
        return this.ageInYears;
    }
    public double getTrunkCircumferenceInCm() {
        return this.trunkCircumferenceInCM;
    }
    public Species getSpecies() {
        return this.typeOfTree;
    }
    public void setAgeInYears(int ageInYears) {
        this.ageInYears = ageInYears;
    } // FIX THIS
    public void setTrunkCircumferenceInCM(double trunkCircumferenceInCm) { // FIX THIS
        this.trunkCircumferenceInCM = trunkCircumferenceInCm;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return ageInYears == tree.ageInYears &&
                Double.compare(tree.trunkCircumferenceInCM, trunkCircumferenceInCM) == 0 &&
                typeOfTree == tree.typeOfTree;
    }
    @Override
    public int hashCode() {
        return Objects.hash(typeOfTree, ageInYears, trunkCircumferenceInCM);
    }
}