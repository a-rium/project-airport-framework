package airport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import airport.flight.CommercialFlight;

public class AirportTest {
	private FlightManager flightManager;
	private Airport airport;
	private FlightData flightData;
	private CommercialFlight flight;
	private Aircraft aircraft;
	
	@BeforeEach
	public void dataSetInitialization() {
		this.airport = new Airport("A");
	}
	
	@Test
	public void flightShouldBeDepartingFromAirport() {
		flightManager = new FlightManager();
		aircraft = new Aircraft(0, 100);
		flightData = new FlightData(airport, airport, null, null);
		flight = new CommercialFlight(flightData, aircraft);
		flightManager.add(flight);
		Assertions.assertTrue(airport.departingFlights(flightManager).contains(flight));
	}
}
