package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static MaintenanceRequestProcessor manager = MaintenanceRequestProcessor.load();
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int choice;

		while (true) {
			try {
				System.out.printf("====== %s ======\n", "Campus Maintenance Request Manager");
				System.out.printf("1. %s\n2. %s\n3. %s\n4. %s\n5. %s\n\nEnter menu option:\n",
						"Add a new maintenance request", "Search for a request by ID",
						"Display pending requests in priority order", "Process The Next Request", " Exit");
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

						manager.add(lInput, dInput, pInput);
					} catch (InputMismatchException e) {
						System.out.println("Invalid Entry Type!");
					}

					break;
				case 2:
					System.out.println("input ID:");
					int idInput = input.nextInt();
					Request request = manager.searchID(idInput);
					if (request == null) {
						System.out.println("Request not found!");
					} else {
						System.out.println(request);
					}
					break;
				case 3:
					manager.displayPendingRequests();
					break;
				case 4:
					manager.processNextRequest();
					break;
				case 5:
					System.out.println("Exiting ...");
					input.close();
					boolean saved = manager.save();
					if(saved == true)
						System.out.println("Data saved successfully");
					else {
						System.out.println("Data not saved");
					}
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Option");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Entry Type! Enter a number from 1-5.");
				input.nextLine();
				continue;
			}
		}

	}

}