package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import airport.Aircraft;
import airport.FlightManager;
import airport.flight.CommercialFlight;

class FlightManagerTest {
	
	FlightManager fm;
	private Aircraft a;
	private CommercialFlight fpf;
	
	@Before
	void init() {
		fm = new FlightManager();
		a = new Aircraft(0, 1);
		fpf = new CommercialFlight("A", "B", a);
		fm.add(fpf);
	}
	
	@Test
	void test() {
		init();
		List l = fm.list(f -> f.equals(null));
		assertTrue(l.isEmpty());
		// Altri test maybe?
	}

}
