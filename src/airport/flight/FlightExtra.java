package airport.flight;

public class FlightExtra {
	private String name;
	private double price;
	
	public FlightExtra(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
}
