package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Main should use this class

public class MaintenanceRequestProcessor  implements Serializable{
	
	int idcout;
	private RequestManager<Request> manager;
	private Heap<Request> pendingRequests;
	
	
	public MaintenanceRequestProcessor(int size){
		manager = new RequestManager<>();
		pendingRequests = new Heap<>(100007);
	}
	
	
	//Q1 complexity O(1) 
	public void add(String location, String description, int priority) {
		
		if(pendingRequests.isFull() || manager.isFull())
			System.out.println("Limit is reached");
		
	    else if (location.equals("") || description.equals(""))
			System.out.println("Location or Description cannot be blank");
	
		else if (priority<1 || priority >3)
			System.out.println("Priority has to be from 1-3");
		
		else {
		Request r = manager.addRequest(location, description, priority); //O(1) if no collision, O(n) if collision
		pendingRequests.insert(getKey(r), r); //O(logn)
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
	
	//saves MaintenanceRequestProcessor object
	public boolean save() {
		try {
			FileOutputStream fout = new FileOutputStream("requests.dat");
			ObjectOutputStream f = new ObjectOutputStream(fout);
			idcout = Request.getIdCount();
			f.writeObject(this);
			f.close();
			return true;
		} catch (Exception e) {
			//System.out.println("Save failed: " + e.getMessage());
			return false;
		}

	}

	
	//loads MaintenanceRequestProcessor object again into my project
	public static MaintenanceRequestProcessor load() {
		
		File file = new File("requests.dat");

		if (!file.exists()) {
			// if file doesnt exist, create a new processor
			return new MaintenanceRequestProcessor(10007);
		}

		try {
			FileInputStream fin = new FileInputStream("requests.dat");
			ObjectInputStream in = new ObjectInputStream(fin);
			MaintenanceRequestProcessor p =  (MaintenanceRequestProcessor) in.readObject();
			Request.setIdCount(p.idcout);
			return p;

		} catch (Exception e) {
			// if the file is corrupted or reading fails, report error and start empty
			System.err.println("Error loading data: " + e.getMessage());
			System.err.println("Starting with an empty request list.");
			return new MaintenanceRequestProcessor(10007);
		}
	}

}

	
