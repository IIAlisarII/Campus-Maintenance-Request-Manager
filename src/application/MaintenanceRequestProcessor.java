package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MaintenanceRequestProcessor implements Serializable {
	private RequestManager<Request> manager;
	private Heap<Request> pendingRequests;
	
	
	public MaintenanceRequestProcessor(){
		manager = new RequestManager<>();
		pendingRequests = new Heap<>(100007);
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
			try (ObjectOutputStream f = new ObjectOutputStream(new FileOutputStream("requests.dat")))
			{
				f.writeObject(this);
				return true;
			}
			catch (IOException e) {
				System.out.println("Save failed: "+e.getMessage());
				e.printStackTrace();
				return false;
			}
				
		}
		
		public static MaintenanceRequestProcessor load() {
			File file = new File("requests.dat");
			
			// if file doesnt exist, create a new processor
			if (!file.exists()) {
				return new MaintenanceRequestProcessor();
			}
			
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
				//read the object and cast it back to RequestManager
				MaintenanceRequestProcessor loadedManager = (MaintenanceRequestProcessor) in.readObject();
				return loadedManager;
				
			} 
			catch (IOException | ClassNotFoundException e) {
		        //if the file is corrupted or reading fails, report error and start empty
		        System.err.println("Error loading data: " + e.getMessage());
		        System.err.println("Starting with an empty request list.");
		        return new MaintenanceRequestProcessor();
		    }
		}
	
}