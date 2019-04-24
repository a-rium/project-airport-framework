package airport;

import airport.order.FlightOrderVisitor;

public interface FlightOrder {
	public double getPrice();
	
	public void add(FlightOrder order) throws UnsupportedOperationException;
	public void remove(FlightOrder order) throws UnsupportedOperationException;
	
	public void accept(FlightOrderVisitor visitor);
}
