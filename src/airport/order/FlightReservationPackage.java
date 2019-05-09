package airport.order;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import airport.FlightOrder;

public class FlightReservationPackage implements FlightOrder, Iterable<FlightOrder> {
	private final List<FlightOrder> orders;

	public FlightReservationPackage() {
		this.orders = new ArrayList<>();
	}

	@Override
	public double getPrice() {
		return orders.stream().mapToDouble(FlightOrder::getPrice).sum();
	}

	@Override
	public void add(FlightOrder order) throws UnsupportedOperationException {
		orders.add(order);
	}

	@Override
	public void remove(FlightOrder order) throws UnsupportedOperationException {
		orders.remove(order);
	}

	@Override
	public void accept(FlightOrderVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public Iterator<FlightOrder> iterator() {
		return orders.iterator();
	}
}
