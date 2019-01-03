package airport;

import java.util.List;

import airport.flight.FixedPriceFlight;
import airport.wallet.StandardWallet;

public class Main
{
	public static void main(String[] args)
	{
		FlightManager manager = new FlightManager();
		Flight pisaFlorence = new FixedPriceFlight("Pisa", "Florence", 100);
		Flight pisaViareggio = new FixedPriceFlight("Pisa", "Viareggio", 1000);
		manager.add(pisaViareggio);
		manager.add(pisaFlorence);
		
		Passenger passenger = new Passenger("Marco", new StandardWallet(1000));
		List<Flight> pisaFlights = manager.list(it -> "Pisa".equals(it.getOrigin()));
		
		for (Flight flight : pisaFlights) {
			passenger.bookFlight(flight);
		}
	}
}
