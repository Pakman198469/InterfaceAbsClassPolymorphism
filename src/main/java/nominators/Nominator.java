package nominators;


/**
 * Defines nominator properties and provides 'nominate' function
 * @author Aleh_Hutyrchyk
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

    public void setNominatorAwardAmount(double nominatorAwardAmount) {
        this.nominatorAwardAmount = nominatorAwardAmount;
    }


}
