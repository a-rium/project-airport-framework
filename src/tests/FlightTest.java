package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import airport.Aircraft;
import airport.Flight;
import airport.Passenger;
import airport.Wallet;
import airport.flight.FixedPriceFlight;
import airport.wallet.StandardWallet;

class FlightTest {
	
	Aircraft a;
	Flight /*press*/ f /*to pay respect*/;
	Wallet w1, w2;
	Passenger p1, p2;

	@Before
	void init() {
		a = new Aircraft(0, 1);
		f = new FixedPriceFlight("A", "B", a, 1);
		w1 = new StandardWallet(1);
		w2 = new StandardWallet(1);
		p1 = new Passenger("p1", w1);
		p2 = new Passenger("p2", w2);
	}
	@Test
	void test() {
		init();
		assertTrue(f.bookSeat(p1));
		assertFalse(f.bookSeat(p2));
	}

}
