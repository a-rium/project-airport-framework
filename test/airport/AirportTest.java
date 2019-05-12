package airport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import airport.flight.CommercialFlight;
import airport.flight.commercial.CommercialFlightData;

public class AirportTest {
	private FlightManager flightManager;
	private Airport airport;
	private CommercialFlightData flightData;
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
		flightData = new CommercialFlightData(airport, airport, null, null);
		flight = new CommercialFlight(flightData, aircraft);
		flightManager.add(flight);
		Assertions.assertTrue(airport.departingFlights(flightManager).contains(flight));
	}
	
	@Test
	public void flightDepartingFromAnotherAirportShouldNotBeReturned() {
		Airport otherAirport = new Airport("B");
		flightManager = new FlightManager();
		aircraft = new Aircraft(0, 100);
		flightData = new CommercialFlightData(otherAirport, airport, null, null);
		flight = new CommercialFlight(flightData, aircraft);
		flightManager.add(flight);
		Assertions.assertFalse(airport.departingFlights(flightManager).contains(flight));
	}
}
