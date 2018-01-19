package employees;

/**
 * Created by Aleh_Hutyrchyk on 1/19/2018.
 */
public class Person {

    private String name;
    private int age;
    private int id;
    private String department;

    /**
     * First constructor for Person
     * @param name - person name
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Second constructor for Person
     * @param name - person name
     * @param age - person age
     * @param id - person id
     * @param department - person dept.
     */
    public Person(String name, int age, int id, String department) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.department = department;
    }

    /**
     * Third constructor for Person; calls Second constructor for Person; parametrized
     * @param i - some external input parameter just for example
     */
    public Person(int i) {
        this("Gogi",31, 42, "Sales"); // Calling second constructor with 4 parameters; parametrized constructor
    }

    /**
     * Indicates usage of method fom Person class
     */
    public void printSomething() {
        System.out.println("Something! FROM PARENT CLASS");
    }

    /**
     * Method will be Overriden in Nominator class
     * @param person - person obj.
     */
    public void printEmplInfo(Person person) {
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
