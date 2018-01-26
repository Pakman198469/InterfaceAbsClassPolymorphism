package nominees;


import awards.Award;
import employees.Person;

/**
 * Defines nominee properties and provides 'receive award' functionality + recalculation for award values
 * @author Aleh_Hutyrchyk
 */
public class Nominee extends Person {
    static{
        System.out.println("Nominee initialized");
    }

    private double quantity;
    private double quantity2;
    private int population; // total count of employee's awards without SOLI
    private int nomineeAwardQuantityLimit;
    private int nomineeAwardQuantity;
    private double awardSumLimit;
    private double nomineeAwardSum;


    /**
     * Constructor for nominee
     * @param name - nominee name
     * @param awardSumLimit - max. sum of awards that nominee can receive
     * @param nomineeAwardQuantityLimit - max. number of awards that can be received
     */
    public Nominee(String name, double awardSumLimit, int nomineeAwardQuantityLimit) {
        super(name);
        this.awardSumLimit = awardSumLimit;
        this.nomineeAwardQuantityLimit = nomineeAwardQuantityLimit;

    }

    /**
     * Method from interface
     * @return {@code true} - if limit was reached <br/>
     *         {@code false} - if limit was not reached
     */
    public boolean isLimitReached() {
        if(nomineeAwardSum >= awardSumLimit) {return true;}
        else {return false;}
    }

    /**
     * Method from interface; verifies if awardSumLimit for nominee is reached
     * @param award - award, used to get award value
     * @return {@code true} - if limit was reached <br/>
     *         {@code false} - if limit was not reached
     */
    public boolean isLimitReached(Award award) {
        if(nomineeAwardSum >= awardSumLimit || awardSumLimit < nomineeAwardSum + award.getValue()) {return true;}
        else {return false;}
    }

    /**
     * Method from interface; verifies if nomineeAwardQuantityLimit was reached
     * @return {@code true} - if limit was reached <br/>
     *         {@code false} - if limit is not reached
     */
    public boolean isQuantityLimitReached() {
        if(nomineeAwardQuantity >= nomineeAwardQuantityLimit) {return true;}
        else {return false;}
    }

    public int nomineeAwardQuantityLimit() {
        return nomineeAwardQuantityLimit;
    }

    public void nomineeAwardQuantityLimit(int nomineeAwardQuantityLimit) {
        this.nomineeAwardQuantityLimit = nomineeAwardQuantityLimit;
    }

    public double getAwardSumLimit() {
        return awardSumLimit;
    }

    public void setAwardSumLimit(double awardSumLimit) {
        this.awardSumLimit = awardSumLimit;
    }

    public int getNomineeAwardQuantityLimit() {
        return nomineeAwardQuantityLimit;
    }

    public int getNomineeAwardQuantity() {
        return nomineeAwardQuantity;
    }

    public void setNomineeAwardQuantity(int nomineeAwardQuantity) {
        this.nomineeAwardQuantity = nomineeAwardQuantity;
    }

    public double getNomineeAwardSum() {
        return nomineeAwardSum;
    }

    public void setNomineeAwardSum(double nomineeAwardSum) {
        this.nomineeAwardSum = nomineeAwardSum;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(double quantity2) {
        this.quantity2 = quantity2;
    }

    @Override
    public String toString() {
        return "Nominee: " + super.toString() + ", got $" + nomineeAwardSum + " in total";
    }
}
