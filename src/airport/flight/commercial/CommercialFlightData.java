package airport.flight.commercial;

import airport.Airport;

public class CommercialFlightData {
	private Airport origin;
	private Airport destination;
	private String departure;
	private String arrival;
	
	public CommercialFlightData(Airport origin, Airport destination, String departure, String arrival) {
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
	public String getDeparture() {
		return departure;
	}
	public String getArrival() {
		return arrival;
	}	
}
