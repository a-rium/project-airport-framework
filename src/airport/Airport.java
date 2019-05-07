package airport;

import java.time.ZoneId;
import java.util.List;

import generic.GenericObserver;

public class Airport implements GenericObserver<FlightNotification> {
	private String name;
	private ZoneId timeZone;

	public Airport(String name, ZoneId timeZone) {
		this.name = name;
		this.timeZone = timeZone;
	}

	public String getName() {
		return name;
	}

	public ZoneId getTimeZone() {
		return timeZone;
	}

	@Override
	public void update(FlightNotification notification) {
		System.out.println(notification.getMessage());
	}

	public List<Flight> departingFlights(FlightManager flightManager) {
		return flightManager.list(flight -> flight.getOrigin().equals(this.getName()));
	}
}
