package airport;

import airport.order.FlightOrderVisitor;

public abstract class FlightReservation implements FlightOrder {
//	private final Passenger passenger;
	private final Flight flight;
	
	public FlightReservation(Flight flight) {
		this.flight = flight;
	}
	
//	
//	public FlightReservation(Passenger passenger, Flight flight) {
//		this.passenger = passenger;
//		this.flight = flight;
//	}

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
