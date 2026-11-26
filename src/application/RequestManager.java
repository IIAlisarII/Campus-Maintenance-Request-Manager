package application;

public class RequestManager<E> {
	private DoubleHashTable<Request> requests = new DoubleHashTable<>(100007); 
	//size should be prime, why?
	//to make sure hashfunc = 9 - k%9  can reach all slots in our array
	
	


	public Request addRequest(String location, String description, int priority) {
		Request r = new Request(location,description,priority);
		requests.insert(r.getRequestID(),r);
		return r;
	}
	
	public Request searchID(int id) {
			return requests.find(id);
	}

	
	public boolean isFull() {
		return requests.isFull();
	}
}