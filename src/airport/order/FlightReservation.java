package airport.order;

import airport.Flight;
import airport.FlightOrder;

public abstract class FlightReservation implements FlightOrder {
	private final Flight flight;
	
	public FlightReservation(Flight flight) {
		this.flight = flight;
	}
	
	public Flight getFlight() {
		return flight;
	}
	
	@Override
	public void add(FlightOrder order) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void remove(FlightOrder order) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void accept(FlightOrderVisitor visitor) {
		visitor.visit(this);
	}
}
