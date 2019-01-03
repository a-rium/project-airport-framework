package airport.flight;

import airport.Flight;
import airport.Passenger;

public class FixedPriceFlight 
	extends Flight
{
	private double price;

	public FixedPriceFlight(String origin, String destination, double price)
	{
		super(origin, destination);
		this.price = price;
	}

	public void bookSeat(Passenger passenger)
	{
		System.out.printf("%s -> %s flight\n", getOrigin(), getDestination());
		System.out.printf("Booking seat for %s\n", passenger.getName());
	}

	@Override
	public double getPrice()
	{
		return price;
	}
}
