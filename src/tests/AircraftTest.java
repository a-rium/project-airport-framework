package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import airport.Aircraft;

class AircraftTest {
	private Aircraft a;
	
	@Before
	public void init() {
		a = new Aircraft(0, 1);
	}
	@Test
	void test() {
		init();
		assertFalse(a.isFull());
		a.bookSeat();
		assertTrue(a.isFull());
	}

}
