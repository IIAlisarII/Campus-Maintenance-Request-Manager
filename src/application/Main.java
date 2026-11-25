/**
 * 
 */
package application;

/**
 * This is where we run the whole thing!
 */
public class Main {
	RequestManager manager =new RequestManager();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int choice;
		while(true) {
       	 System.out.printf("====== %s ======\n", "Campus Maintenance Request Manager");
       	 System.out.printf("1. %s\n2. %s\n3. %s\n0. %s\n\nEnter menu option:\n", 
       			 "Add A New Maintenance Request","Search For A Request By ID",
       			 "Display Pending Requests In Priority Order","Process The Next Request");
       	 
       	 
		}

	}

}
