/**
 * 
 */
package application;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is where we run the whole thing!
 */
public class Main {
	public static MaintenanceRequestProcessor manager =  MaintenanceRequestProcessor.load();
	public static Scanner input = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Loading data (person 4)
		
		
			int choice;
			while(true) {
			try {
	       	 	System.out.printf("====== %s ======\n", "Campus Maintenance Request Manager");
		       	 System.out.printf("1. %s\n2. %s\n3. %s\n4. %s\n5. %s\n\nEnter menu option:\n", 
		       			 "Add a new maintenance request","Search for a request by ID",
		       			 "Display pending requests in priority order","Process The Next Request"
		       			 ,"Exit");
		       	 choice = input.nextInt();
		       	 switch (choice) {
			       	 case 1:
			       		 try {
			       			 input.nextLine();
				       		 System.out.println("input Location:"); 
				       		 String lInput = input.nextLine(); 
				       		 System.out.println("input Description:"); 
				       		 String dInput = input.nextLine(); 
				       		 System.out.println("input Priority (1-3):"); 
				       		 int pInput = input.nextInt(); 
	
				       		 addNewRequest(lInput,dInput,pInput);
			       		 }catch (InputMismatchException e) {
			       			System.out.println("Invalid Entry Type!");
			       		 }
			       		 
			       		 break;
			       	 case 2:
			       		 System.out.println("input ID:"); 
			       		 int idInput = input.nextInt(); 
			       		 searchById(idInput);
			       		 break;
			       	 case 3:
			       		 displayPending();
			       		 break;
			       	 case 4:
			       		 processNextRequest();
			       		 break;
			       	 case 5:
			       		 exit();
			       		 break;
			       	 default:
			       		 System.out.println("Invalid Option"); 
		       	 } 
	       	 }catch(InputMismatchException e) {
				System.out.println("Invalid Entry Type! Enter a number from 1-5.");
				input.nextLine();
				continue;
			}
		}
			
	       	

	}

	private static void exit() {
		System.out.println("Exiting ...");
		input.close();
		manager.save();
		System.exit(0);
	}

	private static void processNextRequest() {
		manager.processNextRequest();
		
	}

	private static void displayPending() {
		manager.displayPendingRequests();
		
	}

	private static void searchById(int i) {
		if(manager.searchID(i)==null) {
			System.out.println("Request not found!");
		}else {
			System.out.println(manager.searchID(i).toString());
		}
		
	}

	private static void addNewRequest(String location, String description, int priority) {
		manager.add(location,description,priority);
		
	}

}
