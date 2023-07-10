package session7.OnlineBiddingSystem;

public class AutomaticBiddingStrategy implements BiddingStrategy {
	
	private double maxBidAmt;
	private double incrementAmt;
	
    public AutomaticBiddingStrategy(double maxBidAmt, double incrementAmt) {
		this.maxBidAmt = maxBidAmt;
		this.incrementAmt = incrementAmt;
	}

	@Override
    public double bid(Item item, User user) {
    	
    	double currentBid = item.getCurrentHighestBid();
		double newBid = currentBid + incrementAmt;
		while(newBid <= maxBidAmt) {
			item.placeBid(user, newBid);
			currentBid = newBid;
			newBid  += incrementAmt;
		}
		return newBid;
    }
}
