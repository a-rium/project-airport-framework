package airport;

import java.util.ArrayList;
import java.util.List;

import generic.GenericObserver;
import generic.ObserverRegistry;

public class PassengerRegistry<T>
	implements ObserverRegistry<T>
{
	private List<GenericObserver<T>> passengers;
	
	public PassengerRegistry() 
	{
		this.passengers = new ArrayList<>();
	}
	
	@Override
	public void add(GenericObserver<T> observer)
	{
		passengers.add(observer);
	}

	@Override
	public void remove(GenericObserver<T> observer)
	{
		passengers.remove(observer);
	}

	@Override
	public void notifyChanges(T data)
	{
		passengers.forEach(it -> it.update(data));
	}
}
