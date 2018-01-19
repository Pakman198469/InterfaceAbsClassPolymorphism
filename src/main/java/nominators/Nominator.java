package nominators;


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
     * Indicates usage of method from Nominator class
     */
    @Override
    public void printSomething() {
        System.out.println("New Nominator created!");
    }

    /**
     * Overriden method from parent class; returns Nominator details
     * @param person - person obj.
     */
    @Override
    public void printEmplInfo(Person person) {
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getId());
        System.out.println(person.getDepartment());
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
