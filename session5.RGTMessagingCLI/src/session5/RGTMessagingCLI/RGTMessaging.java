package session5.RGTMessagingCLI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.print.attribute.standard.JobOriginatingUserName;

public class RGTMessaging {

	// for current user variable
	private User currentUser;

	// to Store multiple user
	private Map<String, User> users;

	// One use have multiple tweet
	private List<Tweet> tweets;
	
	Tweet tweet;

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

	public RGTMessaging() {
		super();
		this.currentUser = null;
		this.tweets = new ArrayList<>();
		this.users = new HashMap<>();
	}

   // For User Register
	public void register(Scanner scanner) {

		System.out.print("Enter Account UserName :");
		String userName = scanner.next();

		if (users.containsKey(userName)) {
			System.out.println("User name already with Us");
			return;
		}

		System.out.print("Enter Password:");
		String password = scanner.next();

		System.out.print("Enter name :");
		String name = scanner.next();

		System.out.print("Enter bio :");
		String bio = scanner.next();

		User user = new User(userName, password, name, bio);
		users.put(userName, user);
		System.out.println("Account created successfully!");
	}

	// For Log-in with a Register user
	public void login(Scanner scanner) {

		System.out.print("Enter Account UserName:");
		String userName = scanner.next();

		System.out.print("Enter Password :");
		String password = scanner.next();

		User user = users.get(userName);

		// If enter user name and password is correct 
		if (user != null && user.getPassword().equals(password)) {
			currentUser = user;
			int choice;
			boolean b = false;
			while (!b) {

				System.out.println("Welcome to RGT:" + userName);
				System.out.println("1. Post a tweet");
				System.out.println("2. View your timline");
				System.out.println("3. Search users");
				System.out.println("4. Search tweets");
				System.out.println("5. View profile");
				System.out.println("6. Logout");
				System.out.print("Enter your choose :");
				choice = scanner.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Post a tweet:");
					postTweet(scanner);
					break;
				case 2:
					System.out.print("View timeline:");
					getTimeline();
					break;
				case 3:
					System.out.print("Search users :");
					searchUser(scanner);
					break;
				case 4:
					System.out.print("Search tweets:");
					searchTweet(scanner);
					break;
				case 5:
					System.out.print("view your profile:");
					getProfile(scanner);
					break;
				case 6:
					b = logout();
					break;
				default:
					System.out.println("invalid choice");
					break;
				}

				System.out.println();

			}

			// if User name and Password is not correct 
		} else {
			System.out.println("Invalid UserName , Password Please try again.");
		}
	}

	//for log-out an Register user
	boolean logout() {
		System.out.println("Logout successfully");
		System.out.println("Thanks you :" + currentUser.getUserName());
		return true;
	}

   // Post tweet
	void postTweet(Scanner scanner) {
		System.out.print("Enter your tweetName :");
		String tweetId = scanner.next();
		System.out.print("Enter content :");
		String content = scanner.next();

		Tweet twt = new Tweet(tweetId, content, currentUser.getUserName(), LocalDateTime.now());
		tweets.add(twt);
		System.out.println("Post your Tweet successfully");
		 
   }

	// Search all register user 
	void searchUser(Scanner scanner) {

		System.out.print("userName");
		String userName = scanner.next();

		if (users.containsKey(userName)) {
			User user = users.get(userName);
			System.out.println(user.getName());
			System.out.println(user.getBio());

		}

	}

	// Serch all tweet you have 
	void searchTweet(Scanner scanner) {
		System.out.print("Eneter TweetName");
		String tweetId = scanner.next();

		for (Tweet tweet : tweets) {
			if (tweet.getTweetId().equals(tweetId)) {
				System.out.println("Your Tweets");
				System.out.println("Tweet Name :" + tweet.getTweetId());
				System.out.println("Tweet contect :" + tweet.getContent());
				System.out.println("Tweet Auther :" + tweet.getAuthor());

			}
		}

	}

	// Get your time Line
	void getTimeline() {
		System.out.println("UserName : " + currentUser.getUserName());
		System.out.println("Your last timeLIne is :" +tweet.getTimestamp());

	}

	// get your Profile
	void getProfile(Scanner scanner) {

		System.out.println(currentUser.getName());
		System.out.println(currentUser.getBio());
		System.out.println(currentUser.getFollowers());
		System.out.println(currentUser.getFollowings());
		System.out.println(currentUser.getTweets());

		System.out.println("");
		boolean b = true;
		while (b) {
			System.out.println("1. add followers");
			System.out.println("2. remove followers");
			System.out.println("3. Back");
			System.out.print("Enter you choice");
			int ch = scanner.nextInt();
			switch (ch) {
			case 1:
				System.out.print("Enter user name for following");
				String userName = scanner.next();
				User user = users.get(userName);
				if (user != null) {
					currentUser.follow(user);
					break;
				}
			case 2:
				System.out.print("Enter user name for following");
				String userName2 = scanner.next();
				User user2 = users.get(userName2);
				if (user2 != null) {
					currentUser.unfollow(user2);
				}
			case 3:
				b = back();
				}
			}

		}

	private boolean back() {
		return false;
	}


}
