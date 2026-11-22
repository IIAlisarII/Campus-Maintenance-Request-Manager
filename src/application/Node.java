package application;

//first link in the chain

import java.io.Serializable;

public class Node implements Serializable {

	MaintenanceRequest request;
	Node next;

	public Node(MaintenanceRequest request) {
		this.request = request;
		this.next = null;
	}

	public MaintenanceRequest getRequest() {
		return request;
	}

	public void setRequest(MaintenanceRequest request) {
		this.request = request;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
