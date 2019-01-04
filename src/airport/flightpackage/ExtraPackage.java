package airport.flightpackage;

import airport.FlightPackage;

public abstract class ExtraPackage
	implements FlightPackage
{
	private FlightPackage pack;
	
	public ExtraPackage(FlightPackage pack)
	{
		this.pack = pack;
	}
	
	@Override
	public double getPrice()
	{
		return pack.getPrice();
	}
}
