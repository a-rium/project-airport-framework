package airport;

import java.util.ArrayList;
import java.util.List;

import generic.GenericObserver;
import generic.ObserverRegistry;

public class FlightObserverRegistry<T extends Passenger> extends ObserverRegistry<T> {
	public FlightObserverRegistry() {
		super();
	}
	
	@Override
	public List<GenericObserver<T>> createObserverList() {
		return new ArrayList<>();
	}
}
