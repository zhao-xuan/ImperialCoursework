package aeroplane;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws MalformedDataException {
		
		if(args.length != 1) {
			System.out.println("Program should be invoked with exactly one argument, the name of the data file");
			System.exit(1);
		}
		
		SeatAllocator allocator = new SeatAllocator();
		
		try {
			allocator.allocate(args[0]);
		} catch (IOException e) {
			System.out.println("An IO exception occurred");
			System.exit(1);
		} catch (AeroplaneFullException e) {
			System.out.println("Unable to allocate all passengers");
		}

		System.out.println(allocator);
		allocator.upgrade();
		System.out.println(allocator);
		
	}

	public static long countAdults(Collection<Passenger> passengers) {
		return passengers.stream().filter(i -> i.isAdult()).count();
	}
}
