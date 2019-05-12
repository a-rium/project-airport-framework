package airport;

import generic.GenericObservable;
import generic.GenericObserver;

// Rappresenta un generico volo.
public abstract class Flight implements GenericObservable<FlightNotification> {
	private Aircraft aircraft;
	private FlightObserverRegistry<FlightNotification> observers; 

	public Flight(Aircraft aircraft) {
		this.aircraft = aircraft;
		this.observers = new FlightObserverRegistry<>();
	}
	
	@Override
	public void addObserver(GenericObserver<FlightNotification> observer) {
		observers.add(observer);
	}
	
	@Override
	public void removeObserver(GenericObserver<FlightNotification> observer) {
		observers.remove(observer);
	}
	
	@Override
	public void notifyObservers(FlightNotification notification) {
		observers.notifyChanges(notification);
	}
	public Aircraft getAircraft() {
		return aircraft;
	}
	public abstract String getOrigin();

	public abstract String getDestination();
}