package airport.order.visitor;

import java.util.List;

import airport.Aircraft;
import airport.Flight;
import airport.FlightOrder;
import airport.FlightReservation;
import airport.FlightReservationPackage;
import airport.Passenger;
import airport.order.FlightOrderVisitor;

public class FlightBookerVisitor implements FlightOrderVisitor {
	private final Passenger client;
	private final List<Flight> flights;
	
	public FlightBookerVisitor(Passenger client, List<Flight> flights) {
		this.client = client;
		this.flights = flights;
	}

	@Override
	public void visit(FlightReservation reservation) {
		Flight flight = reservation.getFlight();
		if (flights.contains(flight)) {
			System.out.printf("Booking flight %s -> %s... ", flight.getOrigin(), flight.getDestination());
			Aircraft aircraft = flight.getAircraft();
			if (!aircraft.isFull()) {
				System.out.println("Success");
				aircraft.bookSeat();
				if (aircraft.isFull()) {
					flights.remove(flight);
				}
				
				flight.addObserver(client);
			} else {
				System.out.println("Failure(Aircraft is full)");
			}
		} else {
			System.out.printf("Error: flight %s -> %s does not correspond to any availble flight\n", 
					flight.getOrigin(), flight.getDestination());
		}
	}

	@Override
	public void visit(FlightReservationPackage reservationPackage) {
		for (FlightOrder order : reservationPackage) {
			order.accept(this);
		}
	}
}
