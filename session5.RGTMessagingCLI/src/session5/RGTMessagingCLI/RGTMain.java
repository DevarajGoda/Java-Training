package session5.RGTMessagingCLI;

import java.util.Scanner;

public class RGTMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		RGTMessaging message = new RGTMessaging();
		int choice;

		do {
			System.out.println("*** Welcome to RGTMessaging! ***");
			System.out.println("1. User Register");
			System.out.println("2. User Log-in");
			System.out.println("3. Exit ");
			System.out.print("Choose an option: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				message.register(scanner);
				break;

			case 2:
				message.login(scanner);
				break;

			case 3:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}

			System.out.println();

		} while (choice != 3);

		scanner.close();
	}
}
