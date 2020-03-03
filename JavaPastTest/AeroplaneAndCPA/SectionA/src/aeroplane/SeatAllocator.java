package aeroplane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SeatAllocator {

	private Map<Seat, Passenger> allocation;

	private static final String CREW = "crew";
	private static final String BUSINESS = "business";
	private static final String ECONOMY = "economy";
	
	public SeatAllocator() {
		allocation = new HashMap<Seat, Passenger>();
	}

	@Override
	public String toString() {
		return allocation.toString();
	}
	
	private void allocateInRange(Passenger passenger,
			Seat first, Seat last) throws AeroplaneFullException, MalformedDataException {
		Seat seat = first;
		Set<Seat> keys = allocation.keySet();
		while (!seat.equals(last)) {
			if (!keys.contains(seat)) {
				if (seat.isEmergencyExit() && passenger.isAdult()){
					seat = seat.next();
					continue;
				}
			}
			seat = seat.next();
		}

		if (keys.contains(seat)) {
			throw new AeroplaneFullException();
		}

		allocation.put(seat, passenger);
	}

	private static String readStringValue(BufferedReader br) throws MalformedDataException, IOException {

		String result = br.readLine();
		
		if(result == null) {
			throw new MalformedDataException();
		}
		
		return result;
		
	}

	private static int readIntValue(BufferedReader br)
			throws MalformedDataException, IOException {
		try {
			return Integer.parseInt(readStringValue(br));
		} catch(NumberFormatException e) {
			throw new MalformedDataException();
		}
	}

	private static Luxury readLuxuryValue(BufferedReader br)
			throws MalformedDataException, IOException {
		try {
			return Luxury.valueOf(readStringValue(br));
		} catch(IllegalArgumentException e) {
			throw new MalformedDataException();
		}
	}

	
	public void allocate(String filename) throws IOException, AeroplaneFullException {
		
		BufferedReader br = new BufferedReader(new FileReader(filename));

		String line;
		while((line = br.readLine()) != null) {
			try {
				if(line.equals(CREW)) {
					allocateCrew(br);
				} else if(line.equals(BUSINESS)) {
					allocateBusiness(br);
				} else if(line.equals(ECONOMY)) {
					allocateEconomy(br);
				} else {
					throw new MalformedDataException();
				}
			} catch(MalformedDataException e) {
				System.out.println("Skipping malformed line of input");
			}
		}
		
	}
	
	private void allocateCrew(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		allocateInRange(new CrewMember(firstName, lastName),
				new Seat(Seat.CREW_ROW, Seat.LETTER_LOWER_BOUND),
				new Seat(Seat.BUSINESS_ROW - 1, Seat.LETTER_UPPER_BOUND));
	}

	private void allocateBusiness(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		int age = readIntValue(br);
		Luxury luxury = readLuxuryValue(br);
		allocateInRange(new BusinessPassenger(firstName, lastName, age, luxury),
				new Seat(Seat.BUSINESS_ROW, Seat.LETTER_LOWER_BOUND),
				new Seat(Seat.ECONOMY_ROW - 1, Seat.LETTER_UPPER_BOUND));
	}

	private void allocateEconomy(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		int age = readIntValue(br);
		allocateInRange(new EconomyPassenger(firstName, lastName, age),
				new Seat(Seat.ECONOMY_ROW, Seat.LETTER_LOWER_BOUND),
				new Seat(Seat.ROW_UPPER_BOUND, Seat.LETTER_UPPER_BOUND));
	}

	public void upgrade() throws MalformedDataException {
		Seat economy = new Seat(Seat.ECONOMY_ROW, Seat.LETTER_LOWER_BOUND);
		Seat business = new Seat(Seat.BUSINESS_ROW, Seat.LETTER_LOWER_BOUND);
		Seat businessLast = new Seat(Seat.ECONOMY_ROW - 1, Seat.LETTER_UPPER_BOUND);
		Set<Seat> key = allocation.keySet();
		do {
			if (key.contains(economy)) {
				do {
					if (!key.contains(business)) {
						allocation.put(business, allocation.get(economy));
						allocation.remove(economy);
					}
				} while (!business.equals(businessLast));
				business = business.next();
			}
			economy = economy.next();
		} while(economy.hasNext());
	}
}
