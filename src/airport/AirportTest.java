package airport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import airport.flight.CommercialFlight;

public class AirportTest {
	FlightManager flightManager;
	private Airport airport1;
	CommercialFlight flight1;
	
	@BeforeEach
	public void dataSetInitialization() {
		flightManager = new FlightManager();
		Aircraft aircraft = new Aircraft(0, 100);
		this.airport1 = new Airport("A");
		Airport airport2 = new Airport("B");
		FlightData flightData1 = new FlightData(airport1, airport2, null, null);
		FlightData flightData2 = new FlightData(airport2, airport1, null, null);
		flight1 = new CommercialFlight(flightData1, aircraft);
		CommercialFlight flight2 = new CommercialFlight(flightData2, aircraft);
		flightManager.add(flight1);
		flightManager.add(flight2);
	}
	
	@Test
	public void departingFlights() {
		Assertions.assertTrue(airport1.departingFlights(flightManager).contains(flight1));
	}
}
