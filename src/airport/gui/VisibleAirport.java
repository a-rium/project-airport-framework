package airport.gui;

import airport.Airport;

public class VisibleAirport extends Airport {
	public VisibleAirport(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
