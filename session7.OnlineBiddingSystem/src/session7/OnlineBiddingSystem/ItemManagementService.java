package session7.OnlineBiddingSystem;

import java.util.ArrayList;
import java.util.List;

public class ItemManagementService {
	
    private Auction auction;
 
    public ItemManagementService() {
        this.auction = Auction.getInstance();
    }
 
    public void addItem(String name, String description, double startingBid) {
        Item item = ItemFactory.createItem(name, description, startingBid);
        auction.addItem(item);
    }
 
    public List<Item> searchItems(String keyword) {
 //Search for items based on keyword
    	List<Item> foundItems = new ArrayList<>();
    	 for(Item item : auction.getItems()) {
    		 if(item.getName().toLowerCase().contains(keyword.toLowerCase())) {
 				foundItems.add(item);
 			}
    	 }
        return foundItems;
    }
 

 //   **********Other methods for managing items and bids
}
