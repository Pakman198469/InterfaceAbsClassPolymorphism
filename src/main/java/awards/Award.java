package awards;


import java.util.List;

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
    private int id;
    private String type;

    /**
     * Constructor for award
     * @param value - award value
     */
    public Award(int value) {
        this.value = value;
    }

    public Award(int value, int id, String type) {
        this.value = value;
        this.id = id;
        this.type = type;
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

    /**
     * Method is overriden to get required String representation.
     * Whenever you print any instance of your class, the default toString implementation
     * of Object class is called, which returns the representation that you are getting.
     * It contains two parts: - Type and Hashcode.
     * @return - award parameters
     */
    @Override
    public String toString() {
        return "Award value = " + value + " " + "ID = " + id + " " + "Type = " + type;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        Award other = (Award) obj;
        if (this.getType().equals(other.getType()))
            return false;
        return true;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
