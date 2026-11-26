package application;


import application.MaintenanceRequest.priority;
import java.io.*;
/**
 *  we will add all the requested methods here :)
 *  and we can also add a different class for files called file manager
 *  to make things more organized 
 */
public class RequestManager implements Serializable { 
	// list or array or hashmap of requests ??
	// also i made both the manager and request serializable because 
	// i still dont know how we want to save the data
	
	// Created a static variable for the filename to avoid typos
	private static final String FILE = "requests.dat";
	
	
	
	public MaintenanceRequest add(String location, String description, priority priority) {
		return null;
		//here we will add the request to the list/ hash map?
		// it will return the object so we can say 
		// object is added
	}
	
	public MaintenanceRequest search(int id) {
		return null;
	}
	
	public void displayPending() {
		
	}
	
	public MaintenanceRequest processNext() {
		return null;
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
	
	public static MaintenanceRequest load() {
		return null;
		// i used static because this will read the file
		// then build the request manager from it 
		// we need it to be static because there wont be
		// a manager instance to build this from
		// because it isnt for a particular object ?
	}
}