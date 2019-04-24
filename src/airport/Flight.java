package airport;

import generic.GenericObservable;
import generic.GenericObserver;
import generic.ObserverRegistry;

// Rappresenta un generico volo.
public abstract class Flight implements GenericObservable<FlightNotification> {
	private String origin;
	private String destination;
	private Aircraft aircraft;
	private ObserverRegistry<FlightNotification> observers; 

	public Flight(String origin, String destination, Aircraft aircraft) {
		this.destination = destination;
		this.origin = origin;
		this.aircraft = aircraft;
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
	
	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}
}