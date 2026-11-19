/**
 * 
 */
package application;
import java.io.Serializable;

import application.MaintenanceRequest.priority;

/**
 *  we will add all the requested methods here :)
 *  and we can also add a different class for files called file manager
 *  to make things more organized 
 */
public class RequestManager implements Serializable{
	// list or array or hashmap of requests ??
	// also i made both the manager and request serializable because 
	// i still dont know how we want to save the data
	
	
	
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
	
	public void save() {
		
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

