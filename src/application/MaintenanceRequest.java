/**
 * 
 */
package application;

import java.io.Serializable;

/**
 * 
 */
public class MaintenanceRequest implements Serializable{
	// user only inputs location + description + priority 
	private static int countID=0;
	public enum priority{
		// i used enumeration here because the options are limited so this will
		// make this easier for us 
		HIGH(1, "High"),
		MEDIUM(2, "Medium"),
		LOW(3, "Low");
		
		private final int number;
		private final String level;
		
		priority(int num, String lev) {
			number=num;
			level=lev;
		}
		
		public int getNumber() {
			return number;
		}
		@Override
		public String toString() {
			return level;
		}
	}
	public enum status{
		// initial status is pending 
		PENDING,
		COMPLETED;
	} 
	
	private int requestID; // this will be assigned automatically (starts from 1)
	private String location; // has the building AND room number %user input
	private String description;// info about problem %user input
	private priority priority;
	private status status;
	
	/*
	 * 
	 * Reject blank locations or descriptions and invalid priorities with an 
	 * appropriate message. <<<< where should i check?
	 * 
	 * */
	
	public MaintenanceRequest(String location,String description, priority priority ) {
		countID++;
		requestID= countID;
		this.location= location;
		this.description= description;
		this.priority=priority;
		this.status= status.PENDING;
	}
}
