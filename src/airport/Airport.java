package airport;

import java.util.List;

import generic.GenericObserver;

public class Airport implements GenericObserver<FlightNotification> {
	private String name;

	public Airport(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void update(FlightNotification notification) {
		System.out.println(notification.getMessage());
	}

	public List<Flight> departingFlights(FlightManager flightManager) {
		return flightManager.list(flight -> flight.getOrigin().equals(this));
	}
}
