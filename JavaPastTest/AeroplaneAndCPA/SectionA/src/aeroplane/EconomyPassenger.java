package aeroplane;

import static aeroplane.PassType.ECONOMY;

public class EconomyPassenger extends Passenger {
    public EconomyPassenger(String firstName, String lastName, int age) {
        super(firstName, lastName, age, ECONOMY);
        assert age >= 0;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Age: " + age;
    }
}
