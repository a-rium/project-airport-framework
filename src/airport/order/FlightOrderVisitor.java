package airport.order;

import airport.FlightReservation;
import airport.FlightReservationPackage;

public interface FlightOrderVisitor {
	public void visit(FlightReservation reservation);
	public void visit(FlightReservationPackage reservationPackage);
}
