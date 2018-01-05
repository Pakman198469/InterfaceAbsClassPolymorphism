package nominators;

import awards.Award;
import checks.LimitChecker;
import nominees.Nominee;

/**
 * Created by Aleh_Hutyrchyk on 12/14/2017.
 */
public class Nominator {
    static{
        System.out.println("Nominator initialized \n");
    }

    private String name;
    private int nominatorAwardQuantityLimit;
    private double nominatorAwardAmountLimit;
    private int nominatorAwardQuantity;
    private double nominatorAwardAmount;

    /**
     * Constructor for Nominator
     * @param name nominator name
     * @param nominatorAwardQuantityLimit - number of awards that nominator can give
     * @param nominatorAwardAmountLimit - max. sum of awards in EUR that nominator can give
     */
    public Nominator(String name, int nominatorAwardQuantityLimit, int nominatorAwardAmountLimit) {
        this.name = name;
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;

    }

    public String getName() {
        return name;
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

    /**
     * Gives award to nominee after limits verification for nominator and nominee;
     * increases nominatorAwardQuantity and nominatorAwardAmount if nomination was successful
     * @param nominee - nominee
     * @param award - award
     * @param checker - limit checker for nominator/nominee
     */
    public void nominate(Nominee nominee, Award award, LimitChecker checker) {
        //System.out.println(nominee1.getName() + " received " + award1.getValue() + " $ award" + "\n");
        if (checker.canNominate(this, nominee, award)) {
            nominee.receiveAward(award);
            nominatorAwardQuantity++;
            nominatorAwardAmount = nominatorAwardAmount + award.getValue();
        } else {
            System.out.println("Vtopku! No more awards!!!");
        }
    }

}
