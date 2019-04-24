//Ancora non fa niente

package tests;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import airport.Aircraft;
import airport.Passenger;
import airport.flight.CommercialFlight;
import airport.wallet.StandardWallet;

public class PassengerTest {
	private Passenger p;
	private Aircraft a;
	private CommercialFlight fpf;
	
	@Before
	public void init() {
		a = new Aircraft(0, 0);
		p = new Passenger("p", new StandardWallet(0.0));
//		fpf = new CommercialFlight("A", "B", a, 1);
	}
	@Test
	void test() {
		init();
//		p.bookFlight(fpf.getPackage());
	}
}
