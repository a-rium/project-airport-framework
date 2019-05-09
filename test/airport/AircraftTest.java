package airport;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AircraftTest {
	private Aircraft aircraft;

	@BeforeEach
	public void dataSetInitialization() {
		this.aircraft = new Aircraft(0, 1);
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
