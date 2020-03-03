package aeroplane;

public abstract class Passenger {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected PassType type;

    public Passenger(String firstName, String lastName, PassType type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }

    public Passenger(String firstName, String lastName, int age, PassType type) {
        this(firstName, lastName, type);
        this.age = age;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public String toString() {
        return "Passenger Type" + type.toString()
                + ", Name: " + firstName + " " + lastName;
    }
}
