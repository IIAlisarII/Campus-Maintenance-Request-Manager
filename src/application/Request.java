package application;

public class Request {
	
	private static int countID = 1 ;
	private int requestID;
	private String location;
	private String description;
	private int priority;
	private Status status;
	
	public Request(String location, String description, int priority) {
		
		if (location.equals("") || description.equals(""))
			System.out.println("Location or Description cannot be blank");
	
		else if (priority<1 || priority >3)
			System.out.println("Priority has to be from 1-3");
		else
		{
		this.priority = priority;
		this.location = location;
		this.description = description;
		this.requestID = countID;
		this.status = Status.PENDING;
		countID++;
		}
		
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
		return "Request Information:\n"
				+ "location:" + location + ", description:" + description + ", priority:" + priority + ", status:"
				+ status ;
	}


	
	
	
	
	
	
	
}
