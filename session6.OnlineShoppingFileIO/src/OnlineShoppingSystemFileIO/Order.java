package OnlineShoppingSystemFileIO;

import java.io.Serializable;
import java.util.HashMap;

public class Order implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int nextConfirmationNumber = 1;

	private int confirmationNumber;
	
	private double totalPrice;
	
	public int getNextConfirmationNumber() {
		return nextConfirmationNumber;
	}

	public void setNextConfirmationNumber(int nextConfirmationNumber) {
		this.nextConfirmationNumber = nextConfirmationNumber;
	}

	private HashMap<Product, Integer> items2;

	public int getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(int confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public HashMap<Product, Integer> getItems2() {
		return items2;
	}

	public void setItems2(HashMap<Product, Integer> items2) {
		this.items2 = items2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Order(HashMap<Product, Integer> items2, double totalPrice ) {
		super();
		this.items2= items2;
		this.confirmationNumber = nextConfirmationNumber ++;
		this.totalPrice = totalPrice;
	}

	
	
}
