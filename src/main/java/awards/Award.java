package awards;

/**
 * Created by Aleh_Hutyrchyk on 12/14/2017.
 */
public class Award {
    static{
        System.out.println("Award initialized");
    }

    private final int value;
    private double soli;

    public Award(int value) {
        this.value = value;
    }

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
