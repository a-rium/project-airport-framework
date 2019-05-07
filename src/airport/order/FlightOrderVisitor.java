package airport.order;

public interface FlightOrderVisitor {
	public void visit(FlightReservation reservation);
	public void visit(FlightReservationPackage reservationPackage);
}
