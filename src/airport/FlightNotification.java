package airport;

public class FlightNotification {
	private final Flight flight;
	private final String message;
	
	public FlightNotification(Flight flight, String message) {
		this.flight = flight;
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Flight getFlight() {
		return flight;
	}
}
