package airport.flight.commercial;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import airport.Aircraft;
import airport.Airport;
import airport.FlightData;
import airport.flight.FlightClass;

class ClasslessFlightTest {
	private ClasslessFlight target;
	private final double price = 100;
	
	@BeforeEach
	public void dataSetInitialization() {
		Aircraft aircraft = new Aircraft(0, 100);
		Airport airport1 = new Airport("A"), airport2 = new Airport("B");
		FlightData flightData = new FlightData(airport1, airport2, null, null);
		this.target = new ClasslessFlight(flightData, aircraft, price);
	}
	
	@Test
	public void hasOnlyOneClass() {
		int nClasses = 0;
		Iterator<FlightClass> it = target.getClasses();
		while (it.hasNext()) {
			nClasses += 1;
			it.next();
		}
		Assertions.assertEquals(nClasses, 1);
	}
	
	@Test
	public void getPrice() {
		Assertions.assertEquals(target.getPrice(), price);
	}
}
