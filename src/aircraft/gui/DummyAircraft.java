package aircraft.gui;

import airport.Aircraft;

public class DummyAircraft extends Aircraft {

	public DummyAircraft(int id) {
		super(id, 0);
	}
	
	@Override
	public void bookSeat() {}
	
	@Override
	public void freeSeat() {}
	
	public boolean isFull() {
		return false;
	}
}
