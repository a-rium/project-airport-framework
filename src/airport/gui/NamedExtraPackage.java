package airport.gui;

import java.util.function.UnaryOperator;

import airport.FlightPackage;

public class NamedExtraPackage implements UnaryOperator<FlightPackage> {
	private final String name;
	private final UnaryOperator<FlightPackage> extra;
	
	public NamedExtraPackage(String name, UnaryOperator<FlightPackage> extra) {
		this.name = name;
		this.extra = extra;
	}

	@Override
	public FlightPackage apply(FlightPackage flightPackage) {
		return extra.apply(flightPackage);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
