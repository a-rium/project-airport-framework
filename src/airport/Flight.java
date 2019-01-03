package airport;

public abstract class Flight
{
	private String origin;
	private String destination;
	
	public Flight(String origin, String destination)
	{
		this.destination = destination;
		this.origin = origin;
	}
	
	public String getOrigin()
	{
		return origin;
	}
	
	public String getDestination()
	{
		return destination;
	}	

	public abstract double getPrice();
	public abstract void bookSeat(Passenger passenger);
}