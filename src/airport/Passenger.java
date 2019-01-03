package airport;

public class Passenger
{	
	private String name;
	private Wallet wallet;
	
	public Passenger(String name, Wallet wallet)
	{
		this.name = name;
	}
	
	public void bookFlight(Flight flight)
	{
		System.out.println("Booking flight...");
		wallet.charge(flight.getPrice());
		flight.bookSeat(this);
	}
	
	public String getName()
	{
		return name;
	}
}
