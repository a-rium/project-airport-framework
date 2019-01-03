package airport;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FlightManager
{
	private List<Flight> flights;
	
	public FlightManager()
	{
		this.flights = new ArrayList<>();
	}
	
	public void add(Flight flight)
	{
		flights.add(flight);
	}
	
	public List<Flight> list(Predicate<Flight> criteria)
	{
		return flights.stream()
				.filter(criteria)
				.collect(Collectors.toList());
	}
}
