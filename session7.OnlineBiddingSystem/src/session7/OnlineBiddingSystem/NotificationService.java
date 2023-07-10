package session7.OnlineBiddingSystem;

public class NotificationService {
	
    public void notifyUser(User user, Item item) {
       //Notify user of outbid
    	System.out.println("Dear User "+ user.getUsername() +",you have been outbid on this item: "+item.getName());
    }
    
    public void subscribeToItem(User user, Item item) {
        UserObserver observer = new UserObserver(user);
        item.addObserver(observer);
    }
    
    public void unsubscribeFromItem(User user, Item item) {
        UserObserver observer = new UserObserver(user);
        item.removeObserver(observer);
    }
}
