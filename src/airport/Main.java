package airport;

import java.util.List;

import airport.flight.FixedPriceFlight;
import airport.flightpackage.extra.ChampagneDuringFlightPackage;
import airport.wallet.StandardWallet;

public class Main {
	public static void main(String[] args) {
		Aircraft boeing = new Aircraft(0, 1);
		FlightManager manager = new FlightManager();
		Flight pisaFlorence = new FixedPriceFlight("Pisa", "Florence", boeing, 0);
		Flight pisaViareggio = new FixedPriceFlight("Pisa", "Viareggio", boeing, 0);
		manager.add(pisaViareggio);
		manager.add(pisaFlorence);

		Passenger passenger = new Passenger("Marco", new StandardWallet(10000));
		List<Flight> pisaFlights = manager.list(it -> "Pisa".equals(it.getOrigin()));

		for (Flight flight : pisaFlights) {
			FlightPackage pack = new ChampagneDuringFlightPackage(flight.getPackage());
			passenger.bookFlight(pack);
			flight.bookSeat(passenger);
		}
	}
}
