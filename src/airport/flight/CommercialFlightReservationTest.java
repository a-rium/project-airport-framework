package airport.flight;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import airport.Aircraft;
import airport.Airport;
import airport.FlightData;

class CommercialFlightReservationTest {
	private CommercialFlightReservation target;
	private final double price = 100;
	
	@BeforeEach
	public void dataSetInitialization() {
		Aircraft aircraft = new Aircraft(0, 100);
		Airport airport1 = new Airport("A"), airport2 = new Airport("B");
		FlightData flightData = new FlightData(airport1, airport2, null, null);
		CommercialFlight flight = new CommercialFlight(flightData, aircraft);
		FlightClass flightClass = new FlightClass("Default", price);
		this.target = new CommercialFlightReservation(flight, flightClass);
	}
	
	@Test
	public void priceWithExtras() {
		final double extraPrice = 200;
		FlightExtra extra = new FlightExtra("Test", extraPrice);
		target.addExtra(extra);
		Assertions.assertEquals(target.getPrice(), price + extraPrice);
	}
	
	@Test
	public void priceWithoutExtras() {
		Assertions.assertEquals(target.getPrice(), price);
	}
}
