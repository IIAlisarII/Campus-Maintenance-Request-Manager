/**
 * 
 */
package application;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is where we run the whole thing!
 */
public class Main {
	public static RequestManager manager =new RequestManager();
	public static Scanner input = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Loading data (person 4)
		try {
			RequestManager.load(); 
			int choice;
			while(true) {
	       	 System.out.printf("====== %s ======\n", "Campus Maintenance Request Manager");
	       	 System.out.printf("1. %s\n2. %s\n3. %s\n4. %s\n5. %s\n\nEnter menu option:\n", 
	       			 "Add a new maintenance request","Search for a request by ID",
	       			 " Display pending requests in priority order","Process The Next Request"
	       			 ,"Exit");
	       	 choice = input.nextInt();
	       	 switch (choice) {
		       	 case 1:
		       		 addNewRequest();
		       		 break;
		       	 case 2:
		       		 searchById();
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
	       	 
			}
		} catch(InputMismatchException e) {
			System.out.println("Invalid Entry Type! Enter a number from 1-5.");
		}

	}

	private static void exit() {
		System.out.println("Exiting ...");
		input.close();
		manager.save();
		System.exit(0);
	}

	private static void processNextRequest() {
		// TODO person 2
		
	}

	private static void displayPending() {
		// TODO person 3
		
	}

	private static void searchById() {
		// TODO person 3
		
	}

	private static void addNewRequest() {
		// TODO person 2
		
	}

}
