package com.rgt.atm;

import java.util.Scanner;

public class Account {

	private String userName;
	private String password;
	private Integer accNo;
	private String acc_type;
	private double balance;
	private double[] transactions = new double[100];
	private int transactionCount = 0;

	Scanner sc = new Scanner(System.in);

	public void openAccount() {
		System.out.print("Enter userName: ");
		userName = sc.next();
		System.out.print("Enter password: ");
		password = sc.next();
		System.out.print("Enter Account No: ");
		accNo = sc.nextInt();
		System.out.print("Enter Account type: ");
		acc_type = sc.next();
		System.out.println("Enter Balance");
		balance = sc.nextDouble();

	}

	public void checkBalance() {
		System.out.println("user balance :" + balance);
	}

	public void deposit() {
		System.out.println("Enter deposit amount: $");
		double amount = sc.nextDouble();
		if (amount > 0) {
			balance = balance + amount;
			System.out.println("Deposit successful!" + amount);
			transactions[transactionCount++] = amount;
		} else {
			System.out.println("Invalid deposit amount.");
		}
	}

	public void withdraw() {
		System.out.println("Enter withdrawal amount: $");
		double amount = sc.nextDouble();
		if (balance >= amount) {
			balance = balance - amount;
			System.out.println("Balance after withdrawal: " + balance);
			transactions[transactionCount++] = -amount;
		} else {
			System.out.println("Your balance is less than " + amount + "\tTransaction failed...!!");
		}
	}

	public void showTransactionHistory() {
		System.out.println("Transaction History:");
		for (int i = 0; i < transactionCount; i++) {
			if (transactions[i] > 0) {
				System.out.println("Deposit: $" + transactions[i]);

			} else {
				System.out.println("Withdraw: $" + (-transactions[i]));
			}
		}
		System.out.println("current amount :" + balance);
	}

	public boolean search(String uName, String pw) {
		if (uName.equals(userName) && pw.equals(password)) {
			return (true);
		}
		return (false);
	}

}
