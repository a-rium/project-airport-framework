package airport;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import generic.GenericObservable;
import generic.GenericObserver;
import generic.ObserverRegistry;

// Rappresenta un generico volo.
public abstract class Flight implements GenericObservable<FlightNotification> {
	private FlightData data;
	private Aircraft aircraft;
	private ObserverRegistry<FlightNotification> observers; 

	public Flight(FlightData data, Aircraft aircraft) {
		this.data = data;
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
		return data.getOrigin().getName();
	}

	public String getDestination() {
		return data.getDestination().getName();
	}

	public Aircraft getAircraft() {
		return aircraft;
	}
}