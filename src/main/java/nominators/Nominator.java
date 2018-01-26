package nominators;


import awards.Award;
import employees.Person;

/**
 * Defines nominator properties and provides 'nominate' function
 * @author Aleh_Hutyrchyk
 */
public class Nominator extends Person {
    static{
        System.out.println("Nominator initialized \n");
    }

    private int nominatorAwardQuantityLimit;
    private double nominatorAwardAmountLimit;
    private int nominatorAwardQuantity;
    private double nominatorAwardAmount;


    /**
     * Constructor for Nominator
     * @param name - nominator name
     * @param nominatorAwardQuantityLimit - number of awards that nominator can give
     * @param nominatorAwardAmountLimit - max. sum of awards in EUR that nominator can give
     */
    public Nominator(String name, int nominatorAwardQuantityLimit, int nominatorAwardAmountLimit) {
        super(name);
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
        super.printSomething();
        this.printSomething();
    }

    /**
     * Constructor for Extended nominator
     * @param name - nominator name
     * @param age- nominator age
     * @param id- nominator id
     * @param department- nominator dep.
     * @param nominatorAwardQuantityLimit - number of awards that nominator can give
     * @param nominatorAwardAmountLimit - max. sum of awards in EUR that nominator can give
     */
    public Nominator(String name, int age, int id, String department, int nominatorAwardQuantityLimit, int nominatorAwardAmountLimit) {
        super(name, age, id, department);
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
    }

    /**
     * Method from interface without parameters
     * @return {@code true} - if limit was reached <br/>
     *         {@code false} - if limit is not reached
     */
    public boolean isLimitReached() {
        return nominatorAwardAmount >= nominatorAwardAmountLimit || nominatorAwardAmountLimit < nominatorAwardAmount;
    }

    /**
     * Method from interface with 1 parameter; verifies if nominatorAwardAmountLimit reached
     * @param award - object, used to get award value
     * @return {@code true} - if limit was reached <br/>
     *         {@code false} - if limit is not reached
     */
    public boolean isLimitReached(Award award) {
        return nominatorAwardAmount >= nominatorAwardAmountLimit || nominatorAwardAmountLimit < nominatorAwardAmount + award.getValue();
    }

    /**
     * Method from interface; verifies if nominatorAwardQuantityLimit reached
     * @return {@code true} - if limit was reached <br/>
     *         {@code false} - if limit is not reached
     */
    public boolean isQuantityLimitReached() {
        return nominatorAwardQuantity >= nominatorAwardQuantityLimit;
    }

    /**
     * Indicates usage of method from Nominator class
     */
    @Override
    public void printSomething() {
        System.out.println("New Nominator created!");
    }

    /**
     * Overriden method from parent class; returns Nominator details
     */
    @Override
    public String toString() {
        return "Nominator(" + getId() + "): " + getName() + ", from " + getDepartment();
    }

    public int getNominatorAwardQuantityLimit() {
        return nominatorAwardQuantityLimit;
    }

    public void setNominatorAwardQuantityLimit(int nominatorAwardQuantityLimit) {
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
    }

    public double getNominatorAwardAmountLimit() {
        return nominatorAwardAmountLimit;
    }

    public void setNominatorAwardAmountLimit(double nominatorAwardAmountLimit) {
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
    }

    public int getNominatorAwardQuantity() {
        return nominatorAwardQuantity;
    }

    public void setNominatorAwardQuantity(int nominatorAwardQuantity) {
        this.nominatorAwardQuantity = nominatorAwardQuantity;
    }

    public double getNominatorAwardAmount() {
        return nominatorAwardAmount;
    }

    public void setNominatorAwardAmount(double nominatorAwardAmount) {
        this.nominatorAwardAmount = nominatorAwardAmount;
    }


}
