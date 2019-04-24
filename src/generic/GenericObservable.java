package generic;

public interface GenericObservable<T> {
	public void addObserver(GenericObserver<T> observer);
	public void removeObserver(GenericObserver<T> observer);
	public void notifyObservers(T data);
}
