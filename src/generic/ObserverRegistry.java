package generic;

import java.util.List;

public abstract class ObserverRegistry<T> {
	private List<GenericObserver<T>> observers;
	
	public ObserverRegistry() {
		this.observers = createObserverList();
	}
	
	public void add(GenericObserver<T> observer) {
		observers.add(observer);
	}

	public void remove(GenericObserver<T> observer) {
		observers.remove(observer);
	}

	public void notifyChanges(T data) {
		observers.forEach(it -> it.update(data));
	}
	
	public abstract List<GenericObserver<T>> createObserverList();
}
