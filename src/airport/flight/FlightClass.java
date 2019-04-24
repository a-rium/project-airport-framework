package airport.flight;

public class FlightClass {
	private String name;
	private double price;
	
	public FlightClass(String name, double price) {
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