package session7.OnlineBiddingSystem;

import java.util.List;
import java.util.Scanner;

public class OnlineBiddingSystem {
	private UserManagementService userManagementService;
	private ItemManagementService itemManagementService;
	private NotificationService notificationService;
   private UserObserver observer;
	private User currentUser;
	Item item=new Item() ;

	Scanner scanner = new Scanner(System.in);

	public OnlineBiddingSystem() {
		this.userManagementService = new UserManagementService();
		this.itemManagementService = new ItemManagementService();
		this.notificationService = new NotificationService();
		this.currentUser = null;
	}

	public void run() {
		boolean exit = false;

		while (!exit) {
			if (currentUser == null) {
				displayLoginMenu();
				int loginOption = scanner.nextInt();

				switch (loginOption) {
				case 1:
					loginUser();
					break;
				case 2:
					createUser();
					break;
				case 3:
					exit = true;
					break;
				}
			} else {
				displayMainMenu();
				int mainMenuOption = getUserInput(4);// getUserInput(3);-->Invalid option. Please try again.

				switch (mainMenuOption) {
				case 1:
					searchItems();
					break;
				case 2:
					viewBiddingHistory();
					break;
				case 3:
					logoutUser();
					break;
				case 4:
					addIteams();
					break;
				default:
					System.out.println("Invalid option. Please try again.");
					displayMainMenu();
					break;
				}
			}
		}

		System.out.println("Goodbye!");
	}

	private void displayLoginMenu() {
		System.out.println("Welcome to the Online Bidding System!");
		System.out.println("1. Login");
		System.out.println("2. Create Account");
		System.out.println("3. Exit");
		System.out.print("Choose an option: ");
	}

	private void displayMainMenu() {
		System.out.println("Welcome to the Online Bidding System!");
		System.out.println("1. Search Items");
		System.out.println("2. View Bidding History");
		System.out.println("3. Logout");
		System.out.println("4. AddItems");
		System.out.print("Choose an option: ");
	}

	private int getUserInput(int maxOption) {
		int option = 0;
		try {
			option = Integer.parseInt(scanner.next());
			if (option < 1 || option > maxOption) {
				System.out.println("Invalid option. Please try again.");

				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid option. Please try again.");
			option = getUserInput(maxOption);
		}
		return option;
	}

	private void loginUser() {
		System.out.print("Enter your username: ");
		String username = scanner.next();// System.console().readLine();
		System.out.print("Enter your password: ");
		String password = scanner.next();// System.console().readLine();

		currentUser = userManagementService.authenticateUser(username, password);

		if (currentUser == null) {
			System.out.println("Invalid username or password. Please try again.");
		} else {
			System.out.println("Login successful!");
		}
	}

	private void createUser() {
		System.out.print("Enter a username: ");
		String username = scanner.next(); 
		System.out.print("Enter a password: ");
		String password = scanner.next(); 

		userManagementService.createUser(username, password);

		System.out.println("Account created successfully!");
	}

	private void logoutUser() {
		currentUser = null;
	}

	private void addIteams() {
		System.out.println("Enter Item Name:");
		String name = scanner.next();
		System.out.println("Enter Description:");
		String description = scanner.next();
		System.out.println("Enter Starting Bid Amount:");
		Double startingBid = scanner.nextDouble();
		itemManagementService.addItem(name, description, startingBid);
		System.out.println("Item Added Successfully.");
	}

	private void searchItems() {
		System.out.println("Enter a search keyword: ");
		String keyword = scanner.next();

		List<Item> searchResults = itemManagementService.searchItems(keyword);
		if (searchResults.isEmpty()) {
			System.out.println("No search Results Found!");
			return;
		}
		System.out.println("Search results:");
		for (int i = 0; i < searchResults.size(); i++) {
			Item item = searchResults.get(i);
			System.out.println((i + 1) + ". " + item.getName() + " - " + item.getDescription()
					+ " - Current highest bid: Rs " + item.getCurrentHighestBid());
		}
		System.out.println("Enter an item number to place a bid, or '0' to go back: ");
		int itemNumber = getUserInput(searchResults.size());

		if (itemNumber == 0) {
			return;
		}

		Item selectedItem = searchResults.get(itemNumber - 1);

		System.out.print("Enter a bid amount: ");
		double bidAmount = Double.parseDouble(scanner.next());
		Bid bid = new Bid(currentUser, selectedItem, bidAmount);
		System.out.println("1. Incremental Bidding");
		System.out.println("2. Automatic Bidding");
		System.out.println("Choose a bidding strategy:");
		int biddingStrategyOption = getUserInput(2);
		BiddingStrategy biddingStrategy;

		switch (biddingStrategyOption) {
		case 1:
			biddingStrategy = new IncrementalBiddingStrategy();
			break;
		case 2:
			biddingStrategy = new AutomaticBiddingStrategy(item.getCurrentHighestBid(), bidAmount);
			break;
		default:
			System.out.println("Invalid option. Using incremental bidding strategy.");
			biddingStrategy = new IncrementalBiddingStrategy();
			break;
		}

		double newBid = biddingStrategy.bid(selectedItem, currentUser);

		System.out.println("Bid placed successfully.\n" + "Your bid amount: Rs " + newBid);
	}

	private void viewBiddingHistory() {
		if (currentUser == null) {
			System.out.println("You must be logged in to view your bidding history.");
			return;
		}
		User user = userManagementService.getUser();
		if (user != null) {
			// Get the bidding history for the user
			List<Bid> biddingHistory = currentUser.getBiddingHistory();
			if (biddingHistory.isEmpty()) {
				System.out.println("You Don't Have Any History");
				return;
			}
			System.out.println("Your bidding history:");
			int count = 1;
			for (Bid bid : biddingHistory) {
				System.out.println(count + ". " + bid.getItem().getName() + " - " + bid.getItem().getDescription()
						+ " - Bid amount: " + bid.getAmount() + " - Winning bid: " + bid.isWinningBid());
				count++;
			}
		}
	}
   
	public static void main(String[] args) {
		OnlineBiddingSystem biddingSystem = new OnlineBiddingSystem();
		biddingSystem.run();
	}

}
