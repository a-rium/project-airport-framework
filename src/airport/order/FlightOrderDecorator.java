package airport.order;

import airport.FlightOrder;

public class FlightOrderDecorator implements FlightOrder {
	private FlightOrder component;
	
	public FlightOrderDecorator(FlightOrder component) {
		this.component = component;
	}
	
	@Override
	public double getPrice() {
		return component.getPrice();
	}

	@Override
	public void add(FlightOrder order) throws UnsupportedOperationException {
		component.add(order);
	}

	@Override
	public void remove(FlightOrder order) throws UnsupportedOperationException {
		component.remove(order);
	}

	@Override
	public void accept(FlightOrderVisitor visitor) {
		component.accept(visitor);
	}
}
