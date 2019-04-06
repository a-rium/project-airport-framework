package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import airport.Aircraft;

class AircraftTest {
	private Aircraft aircraft;

	@BeforeEach
	public void init() {
		aircraft = new Aircraft(0, 1);
	}

	@Test
	public void newAircraftShouldNotBeFull() {
		assertFalse(aircraft.isFull());
	}

	@Test
	public void fullyBookedAircraftShouldBeFull() {
		aircraft.bookSeat();
		assertTrue(aircraft.isFull());
	}

}
