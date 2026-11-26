package application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MaintenanceRequestProcessor {
	private RequestManager<Request> manager;
	private Heap<Request> pendingRequests;
	
	
	public MaintenanceRequestProcessor(int size){
		manager = new RequestManager<>();
		pendingRequests = new Heap<>(100007);
	}
	
	public MaintenanceRequestProcessor() {
		// TODO why do we need an int ?
	}

	public Request search(int id) {
		return manager.searchID(id);
	}
	
	
	//Q1
	public void add(String location, String description, int priority) {
		
		if(pendingRequests.isFull() || manager.isFull())
			System.out.println("Limit is reached");
		
	    else if (location.equals("") || description.equals(""))
			System.out.println("Location or Description cannot be blank");
	
		else if (priority<1 || priority >3)
			System.out.println("Priority has to be from 1-3");
		
		else {
		Request r = manager.addRequest(location, description, priority);
		pendingRequests.insert(getKey(r), r);
		}
		
	}
	
	//Q2
	public Request searchID(int id) {
		return manager.searchID(id);
	}
	
	
	
	//Q3
	public void displayPendingRequests() {
		if (!pendingRequests.isEmpty()) {
		
		Node<Request> node = pendingRequests.removeMax();
		System.out.println(node.data);
		displayPendingRequests();
		pendingRequests.insert(node.key,node.data);
		}
	}
	
	//Q4
	public void processNextRequest() {
		if (pendingRequests.isEmpty()) {
			System.out.println("No pending requests");
			return;
			
		}
			
		Request r = pendingRequests.removeMax().data;
		r.completeRequest();
		System.out.println("Next Request Proccessed");
		
	}
	
	private int getKey(Request r) {
		int p = r.getPriority();
		int id = r.getRequestID();
		
		int k = (4-p)*100007-id;
		return k;
		
	}
	// i set save() as a boolean so that it simply flags whether the save
		// was successful or not
		public boolean save(){
			try (ObjectOutputStream f = new ObjectOutputStream(new FileOutputStream(FILE)))
			{
				f.writeObject(this);
				return true;
			}
			catch (IOException e) {
				System.out.println("Save failed: " + e.getMessage());
				return false;
			}
				
		}
		
		public static Request load() {
			return null;
			// i used static because this will read the file
			// then build the request manager from it 
			// we need it to be static because there wont be
			// a manager instance to build this from
			// because it isnt for a particular object ?
		}
	
}