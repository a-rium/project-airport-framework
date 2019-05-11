package airport;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import airport.Aircraft;
import airport.FlightManager;
import airport.flight.CommercialFlight;

class FlightManagerTest {
	private FlightManager flightManager;
	private CommercialFlight flight;
	private Aircraft aircraft;

	@BeforeEach
	void dataSetInitialization() {
		flightManager = new FlightManager();
	}

	@Test
	void flightManagerShouldAddFlight() {
		aircraft = new Aircraft(0, 1);
		flight = new CommercialFlight(null, aircraft);
		flightManager.add(flight);
		List<Flight> list = flightManager.list(f -> true);
		assertTrue(list.contains(flight));
	}

}