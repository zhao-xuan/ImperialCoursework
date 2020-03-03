package aeroplane;

import static aeroplane.PassType.CREW;

public class CrewMember extends Passenger {
    public CrewMember(String firstName, String lastName) {
        super(firstName, lastName, CREW);
    }

    @Override
    public boolean isAdult() {
        return true;
    }
}
