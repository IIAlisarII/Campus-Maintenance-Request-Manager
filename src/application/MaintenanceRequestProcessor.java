package application;

public class MaintenanceRequestProcessor {
	private RequestManager<Request> manager;
	private Heap<Request> pendingRequests;
	
	
	public MaintenanceRequestProcessor(int size){
		manager = new RequestManager<>();
		pendingRequests = new Heap<>(100000);
	}
	
	public Request search(int id) {
		return manager.searchID(id);
	}
	
	
	public void add(String location, String description, int priority) {
		
		Request r = manager.addRequest(location, description, priority);
		pendingRequests.insert(getKey(r), r);
		
	}
	
	
	private int getKey(Request r) {
		int p = r.getPriority();
		int id = r.getRequestID();
		
		int k = (4-p)*pendingRequests.size()-id;
		return k;
		
		
	}
	
	public void processNextRequest() {
		if (pendingRequests.isEmpty()) {
			System.out.println("No pending requests");
			return;
			
		}
			
		Request r = pendingRequests.removeMax().data;
		r.completeRequest();
		System.out.println("Next Request Proccessed");
		
	}
	
	

	
	
	public void displayPendingRequests2() {
		if (!pendingRequests.isEmpty()) {
		
		Node<Request> node = pendingRequests.removeMax();
		System.out.println(node.data);
		displayPendingRequests2();
		pendingRequests.insert(node.key,node.data);
		}
	}
	
	
	
	
	
}
