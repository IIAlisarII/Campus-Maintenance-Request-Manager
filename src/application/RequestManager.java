package application;

public class RequestManager<E> {
	private DoubleHashTable<Request> requests = new DoubleHashTable<>(100000);
	
	


	public Request addRequest(String location, String description, int priority) {
		Request r = new Request(location,description,priority);
		requests.insert(r.getRequestID(),r);
		return r;
	}
	
	public Request searchID(int id) {
			return requests.find(id);
	}

}
