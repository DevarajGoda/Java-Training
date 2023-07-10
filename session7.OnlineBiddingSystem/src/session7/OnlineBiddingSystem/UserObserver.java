package session7.OnlineBiddingSystem;


public class UserObserver implements Observer {
    private User user;

    public UserObserver(User user) {
        this.user = user;
    }

    public void update(Item item) {
    	
//  Notify user of outbid
    	
    	if (item.getHighestBidder() != null && item.getHighestBidder().equals(user)) {
			System.out.println("You are the highest bidder for the " + item.getName() + ".");
		} else {
			System.out.println("You have been outbid on item : " + item.getName());

		}
    }
}
