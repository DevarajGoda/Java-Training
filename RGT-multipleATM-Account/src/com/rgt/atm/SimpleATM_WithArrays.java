package com.rgt.atm;

import java.util.Scanner;

public class SimpleATM_WithArrays {

	public static void main(String[] args) {

		System.out.println("Enter no of account want to create :");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Account acc[] = new Account[n];
		System.out.println("Enter account detelis : ");
		for (int i = 0; i < acc.length; i++) {
			acc[i] = new Account();
			acc[i].openAccount();
		}

		int choice;

		do {
			System.out.println("Welcome to the ATM Simulator");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. View Transaction History");
			System.out.println("5. Exit");
			System.out.print("Choose an option: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter UserName : ");
				String uName = sc.next();
				System.out.print("Enter password : ");
				String pw = sc.next();
				boolean bo = false;
				for (int i = 0; i < acc.length; i++) {
					bo = acc[i].search(uName, pw);
					if (bo) {
						acc[i].checkBalance();
						break;
					}
				}
				if (!bo) {
					System.out.println("Search failed! Entered Username or Password is worng..!!");
				}
				break;

			case 2:
				System.out.print("Enter UserName : ");
				uName = sc.next();
				System.out.print("Enter password : ");
				pw = sc.next();
				bo = false;
				for (int i = 0; i < acc.length; i++) {
					bo = acc[i].search(uName, pw);
					if (bo) {
						acc[i].deposit();
						break;
					}
				}
				if (!bo) {
					System.out.println("Search failed! Entered Username or Password is worng..!!");
				}
				break;

			case 3:
				System.out.print("Enter UserName : ");
				uName = sc.next();
				System.out.print("Enter password : ");
				pw = sc.next();
				bo = false;
				for (int i = 0; i < acc.length; i++) {
					bo = acc[i].search(uName, pw);
					if (bo) {
						acc[i].withdraw();
						break;
					}
				}
				if (!bo) {
					System.out.println("Search failed! Entered Username or Password is worng..!!");
				}
				break;

			case 4:
				System.out.print("Enter UserName : ");
				uName = sc.next();
				System.out.print("Enter password : ");
				pw = sc.next();
				bo = false;
				for (int i = 0; i < acc.length; i++) {
					bo = acc[i].search(uName, pw);
					if (bo) {
						acc[i].showTransactionHistory();
						break;
					}
				}
				if (!bo) {
					System.out.println("Search failed! Entered Username or Password is worng..!!");
				}
				break;
			case 5:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}

			System.out.println();

		} while (choice != 5);

		sc.close();
	}
}
