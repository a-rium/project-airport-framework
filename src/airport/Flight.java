package airport;

import generic.GenericObservable;
import generic.GenericObserver;

// Rappresenta un generico volo.
public abstract class Flight implements GenericObservable<FlightNotification> {
	private FlightData flightData;
	private Aircraft aircraft;
	private FlightObserverRegistry<FlightNotification> observers; 

	public Flight(FlightData flightData, Aircraft aircraft) {
		this.flightData = flightData;
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
	
	public String getOrigin() {
		return flightData.getOrigin().getName();
	}

	public String getDestination() {
		return flightData.getDestination().getName();
	}

	public Aircraft getAircraft() {
		return aircraft;
	}
}