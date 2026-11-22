package application;

import java.io.Serializable;

public class HashTable implements Serializable{

	Node[] requestsList;
	int Size;
	
	public HashTable(int size) {
		requestsList= new Node[size];
	}
	
	private int Index(int id) {// position in hashTable
			return id% requestsList.length;
	}
	
	public void insertRequest(MaintenanceRequest n) {
		Node i= new Node(n);
		Size++;
		
		int index= Index(n.getID());// find drawer
		
		i.setNext(requestsList[index]);//tie new box to old chain
		
		requestsList[index]=i;
	}
	
	public MaintenanceRequest getRequest(int id){
		int index= Index(id);
		Node current= requestsList[index];// current is a request
		
		
		while(current!=null) {
			
			if(current.getRequest().getID()==id)//if found
				return current.getRequest();
			else{
				current=current.getNext();
			}
			}return null;
			
		}
		
}
