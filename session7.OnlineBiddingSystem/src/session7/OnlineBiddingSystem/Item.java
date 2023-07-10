package session7.OnlineBiddingSystem;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String name;
    private String description;
    private double currentHighestBid;
    private User highestBidder;
    private List<UserObserver> observers;

    public Item(String name, String description, double startingBid) {
        this.name = name;
        this.description = description;
        this.currentHighestBid = startingBid;
        
        this.highestBidder = null;
        this.observers = new ArrayList<>();
    }

        public Item() {
		 
	}

		public void placeBid(User user, double bidAmount) {
        if (bidAmount > currentHighestBid) {
        	if (highestBidder != null) {
        		notifyOutbid(highestBidder);
        	}
        	
            currentHighestBid = bidAmount;
            highestBidder = user;
            user.addBid(new Bid(this, bidAmount));
            this.observers = new ArrayList<>();
        }
    }

		public double getCurrentHighestBid() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public void notifyOutbid(User user) {
			for (UserObserver observer : observers) {
				observer.update(this);
			}
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public User getHighestBidder() {
			return highestBidder;
		}

		public void setHighestBidder(User highestBidder) {
			this.highestBidder = highestBidder;
		}

		public List<UserObserver> getObservers() {
			return observers;
		}

		public void setObservers(List<UserObserver> observers) {
			this.observers = observers;
		}

		public void setCurrentHighestBid(double currentHighestBid) {
			this.currentHighestBid = currentHighestBid;
		}

		public void addObserver(UserObserver observer) {
			observers.remove(observer);
			
		}

		public void removeObserver(UserObserver observer) {
			for (UserObserver observer2 : observers) {
				observer.update(this);
			
		   }
		}	
}
