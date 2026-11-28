package application;

import java.io.Serializable;

public class Request implements Serializable{
	
	private static int countID = 1 ;
	private int requestID;
	private String location;
	private String description;
	private int priority;
	private Status status;
	
	public Request(String location, String description, int priority) {
		this.priority = priority;
		this.location = location;
		this.description = description;
		this.requestID = countID;
		this.status = Status.PENDING;
		countID++;

	}
	
	public static int getIdCount() {
		return countID;
	}
	
	public static void setIdCount(int count) {
		countID = count;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void completeRequest() {
		status =Status.COMPLETED;
	}

	@Override
	public String toString() {
		return 
				"Id: "+requestID+ ", location:" + location + ", description:" + description + ", priority:" + priority + ", status:"
				+ status ;
	}


	
	
	
	
	
	
	
}
