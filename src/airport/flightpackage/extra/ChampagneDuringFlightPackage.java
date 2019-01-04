package airport.flightpackage.extra;

import airport.FlightPackage;
import airport.flightpackage.ExtraPackage;

public class ChampagneDuringFlightPackage
	extends ExtraPackage
{
	public ChampagneDuringFlightPackage(FlightPackage pack) 
	{
		super(pack);
	}

	@Override
	public double getPrice()
	{
		return super.getPrice() + 20;
	}
}
