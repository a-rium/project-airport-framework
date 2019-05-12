package airport.flight;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import airport.Aircraft;
import airport.Airport;
import airport.Flight;
import airport.flight.commercial.CommercialFlightData;

public class CommercialFlight extends Flight {
	private List<FlightClass> classes;
	private List<FlightExtra> extras;
	private CommercialFlightData flightData;

	public CommercialFlight(CommercialFlightData flightData, Aircraft aircraft) {
		super(aircraft);
		this.flightData = flightData;
		this.classes = new ArrayList<>();
		this.extras = new ArrayList<>();
	}

	public void addClass(FlightClass flightClass) {
		classes.add(flightClass);
	}
	
	public Iterator<FlightClass> getClasses() {
		return classes.iterator();
	}
	
	public void addExtra(FlightExtra extra) {
		extras.add(extra);
	}
	
	public Iterator<FlightExtra> getExtras() {
		return extras.iterator();
	}
	
	public Airport getOrigin() {
		return flightData.getOrigin();
	}

	public Airport getDestination() {
		return flightData.getDestination();
	}

}
