package awards;

/**
 * Defines award properties
 * @author Aleh_Hutyrchyk
 */
public class Award {
    static{
        System.out.println("Award initialized");
    }

    private final int value;
    private double soli;

    /**
     * Constructor for award
     * @param value - award value
     */
    public Award(int value) {
        this.value = value;
    }

    /**
     * Constructor for award with SOLI
     * @param value - award value
     * @param soli - SOLI value for award
     */
    public Award(int value, double soli) {
        this.value = value;
        this.soli = soli;
    }

    public int getValue() {
        return value;
    }

    public double getSoli() {
        return soli;
    }

    public void setSoli(double soli) {
        this.soli = soli;
    }
}
