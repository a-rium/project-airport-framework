package airport;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import airport.order.visitor.FlightBookerVisitor;

public class FlightManager {
	private List<Flight> flights;

	public FlightManager() {
		this.flights = new ArrayList<>();
	}

	public void add(Flight flight) {
		flights.add(flight);
	}

	public List<Flight> list(Predicate<Flight> criteria) {
		return flights.stream().filter(criteria).collect(Collectors.toList());
	}
	
	public boolean finalizeOrder(Passenger client, FlightOrder order) {
		double price = order.getPrice();
		
		boolean success = client.pay(price);
		if (success) {
			order.accept(new FlightBookerVisitor(client, flights));
		} 

		return success;
	}
}