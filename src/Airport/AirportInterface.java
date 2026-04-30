package Airport;

public interface AirportInterface<T> {
	void enqueue(T newEntry);
    T dequeue();
    boolean isEmpty();
	int sizeOf();
}
