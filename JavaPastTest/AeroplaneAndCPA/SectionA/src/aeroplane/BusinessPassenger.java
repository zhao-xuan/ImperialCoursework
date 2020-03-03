package aeroplane;

import static aeroplane.PassType.BUSINESS;

public class BusinessPassenger extends Passenger {
    Luxury luxury;

    public BusinessPassenger(String firstName, String lastName, int age, Luxury luxury) {
        super(firstName, lastName, BUSINESS);
        assert age >= 0;
        this.luxury = luxury;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Age: " + age
                + ", Luxury: "+ luxury;
    }
}
