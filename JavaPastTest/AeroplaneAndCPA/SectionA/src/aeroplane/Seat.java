package aeroplane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Seat {
    public static final int ROW_LOWER_BOUND = 1;
    public static final int ROW_UPPER_BOUND = 50;
    public static final char LETTER_LOWER_BOUND = 'A';
    public static final char LETTER_UPPER_BOUND = 'F';
    public static final int CREW_ROW = 1;
    public static final int BUSINESS_ROW = 2;
    public static final int ECONOMY_ROW = 16;
    public static final List<Integer> EMERGENCY_ROWS = new ArrayList<Integer>(Arrays.asList(1, 10, 30));

    private final int row;
    private final char letter;
    private boolean isEmergency;
    private PassType type;

    public int getRow() {
        return row;
    }

    public char getLetter() {
        return letter;
    }

    public PassType getPassType() {
        return type;
    }

    public Seat(int row, char letter) throws MalformedDataException {
        if (row >= ROW_LOWER_BOUND && row <= ROW_UPPER_BOUND
                && letter >= LETTER_LOWER_BOUND && letter <= LETTER_UPPER_BOUND) {
            this.row = row;
            this.letter = letter;
            setSeatClass();
        } else {
            throw new MalformedDataException();
        }
    }

    public String toString() {
        return Integer.toString(row) + letter;
    }

    public boolean isEmergencyExit() {
        return isEmergency;
    }

    public boolean hasNext() {
        return !(row == ROW_UPPER_BOUND && letter == LETTER_UPPER_BOUND);
    }

    public Seat next() throws MalformedDataException {
        if (hasNext()) {
            if (letter == LETTER_UPPER_BOUND) {
                return new Seat(row + 1, letter);
            } else {
                return new Seat(row, (char) (letter + 1));
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    private void setEmergency() {
        if (EMERGENCY_ROWS.contains(row)) {
            isEmergency = true;
        }
    }

    private void setSeatClass() {
        if (row >= CREW_ROW && row < BUSINESS_ROW) {
            type = PassType.CREW;
        } else if (row >= BUSINESS_ROW && row < ECONOMY_ROW) {
            type = PassType.BUSINESS;
        } else if (row >= ECONOMY_ROW) {
            type = PassType.ECONOMY;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Seat) {
            return row == ((Seat) obj).getRow()
                    && letter == ((Seat) obj).getLetter()
                    && isEmergency == ((Seat) obj).isEmergencyExit()
                    && type == ((Seat) obj).getPassType();
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        return row + letter;
    }
}
