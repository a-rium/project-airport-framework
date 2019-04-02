package generic;

public interface ObserverRegistry<T> {
	public void add(GenericObserver<T> observer);

	public void remove(GenericObserver<T> observer);

	public void notifyChanges(T data);
}
