package airport;

import java.time.ZonedDateTime;

public class FlightData {
	private Airport origin;
	private Airport destination;
	private ZonedDateTime departure;
	private ZonedDateTime arrival;
	
	public FlightData(Airport origin, Airport destination, ZonedDateTime departure, ZonedDateTime arrival) {
		this.origin = origin;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
	}
	public Airport getOrigin() {
		return origin;
	}
	public Airport getDestination() {
		return destination;
	}
	public ZonedDateTime getDeparture() {
		return departure;
	}
	public ZonedDateTime getArrival() {
		return arrival;
	}	
}
