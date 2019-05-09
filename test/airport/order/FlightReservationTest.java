package airport.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import airport.Aircraft;
import airport.Airport;
import airport.Flight;
import airport.FlightData;
import airport.flight.commercial.ClasslessFlight;

public class FlightReservationTest {
	public class DummyFlightReservation extends FlightReservation {
		public DummyFlightReservation(Flight flight) {
			super(flight);
		}

		@Override
		public double getPrice() {
			return 0;
		}
	}

	private FlightReservation target;
	
	@BeforeEach
	public void dataSetInitialization() {
		Aircraft aircraft = new Aircraft(0, 100);
		Airport fromAirport = new Airport("Pistoia");
		Airport toAirport = new Airport("Firenze");
		FlightData flightData = new FlightData(fromAirport, toAirport, null, null);
		Flight flight = new ClasslessFlight(flightData, aircraft, 100);

		
		target = new DummyFlightReservation(flight);
	}
	
	@Test
	public void cannotAddComponentsToIt() {
		Aircraft aircraft = new Aircraft(0, 100);
		Airport fromAirport = new Airport("Firenze");
		Airport toAirport = new Airport("Pistoia");
		FlightData flightData = new FlightData(fromAirport, toAirport, null, null);
		Flight flight = new ClasslessFlight(flightData, aircraft, 100);
		
		FlightReservation other = new DummyFlightReservation(flight);
		
		Assertions.assertThrows(Exception.class, () -> target.add(other));
	}

	@Test
	public void cannotRemoveComponentsFromIt() {
		Aircraft aircraft = new Aircraft(0, 100);
		Airport fromAirport = new Airport("Firenze");
		Airport toAirport = new Airport("Pistoia");
		FlightData flightData = new FlightData(fromAirport, toAirport, null, null);
		Flight flight = new ClasslessFlight(flightData, aircraft, 100);
		
		FlightReservation other = new DummyFlightReservation(flight);
		
		Assertions.assertThrows(Exception.class, () -> target.remove(other));
	}
}
