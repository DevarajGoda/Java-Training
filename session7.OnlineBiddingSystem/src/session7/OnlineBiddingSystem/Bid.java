package session7.OnlineBiddingSystem;

public class Bid {
	
	private double amount;
	private boolean winningBid;
	
	private Item item;
	private User user;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isWinningBid() {
		return winningBid;
	}
	public void setWinningBid(boolean winningBid) {
		this.winningBid = winningBid;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Bid(User user, Item item, double amount) {
		this.amount = amount;
		this.winningBid = false;
		this.item = item;
		this.user = user;
		user.addBid(this); // Add the every bid to the user's Bidding history 
	}
	
	public Bid(Item item, double amount) {
		this.item = item;
		this.amount = amount;
		System.out.println("test the bid calling :");
	}
	
	 
	
	
	
	

}
