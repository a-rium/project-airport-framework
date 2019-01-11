package airport;

import generic.ObserverRegistry;

public abstract class Flight
{
	private String origin;
	private String destination;
	private Aircraft aircraft;
	
	public Flight(String origin, String destination, Aircraft aircraft)
	{
		this.destination = destination;
		this.origin = origin;
		this.aircraft = aircraft;
	}
	
	public String getOrigin()
	{
		return origin;
	}
	
	public String getDestination()
	{
		return destination;
	}	
	
	public Aircraft getAircraft()
	{
		return aircraft;
	}

	public abstract FlightPackage getPackage();
	public abstract void bookSeat(Passenger passenger);
}