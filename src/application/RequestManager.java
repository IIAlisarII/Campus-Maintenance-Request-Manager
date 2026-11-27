package application;

import java.io.Serializable;

public class RequestManager<E> implements Serializable {
	private DoubleHashTable<Request> requests = new DoubleHashTable<>(100007);

	public Request addRequest(String location, String description, int priority) {
		Request r = new Request(location, description, priority);
		requests.insert(r.getRequestID(), r);
		return r;
	}

	public Request searchID(int id) {
		return (Request) requests.find(id);
	}

	public boolean isFull() {
		return requests.isFull();
	}
}