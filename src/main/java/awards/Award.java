package awards;


import java.util.List;
import java.util.Objects;

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

    /**
     * Method compares two objects on specific fields.
     * Use the same set of fields that you use to compute equals() to compute hashCode()!!!
     * @param o - incoming object
     * @return {@code true} - identical objects <br/>
     *         {@code false} - different objects <br/>
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Award award = (Award) o;
        return Objects.equals(type, award.type);
    }

    /**
     * Generates hashCode on the basis of specific fields of objects.
     * when we override equals(), it is recommended to also override the hashCode() method.
     * If we don’t do so, equal objects may get different hash-values; and hash based collections,
     * including HashMap, HashSet, and HashTable do not work properly.
     * @return - hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(type);
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
