package airport.flight;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import airport.Aircraft;
import airport.Flight;

public class CommercialFlight extends Flight {
	private List<FlightClass> classes;
	private List<FlightExtra> extras;

	public CommercialFlight(String origin, String destination, Aircraft aircraft) {
		super(origin, destination, aircraft);
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
}
