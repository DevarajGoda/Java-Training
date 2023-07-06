package OnlineShoppingSystemFileIO;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

	HashMap<Product, Integer> items;

	HashMap<String, Product> listItems;
	
	int itemsQunt;

	public HashMap<Product, Integer> getItems() {
		return items;
	}

	public void setItems(HashMap<Product, Integer> items) {
		this.items = items;
	}

	public ShoppingCart() {
		items = new HashMap<>();
		 
	}

	public void addItem(Product product, int quantity) {
		if (items.containsKey(product)) {
			int currentQuentity = items.get(product);
			items.put(product, currentQuentity + quantity);
		} else {
			items.put(product, quantity);
		}
		itemsQunt = quantity;
	}

	public void removeItem(Product pName, int quentity) {
		items.remove(pName, quentity);
		System.out.println("items remove successful");

	}

   public void cartDisplay() {
	   for (Map.Entry<Product, Integer> entry : items.entrySet()) {
           Product product = entry.getKey();
           int quantity = itemsQunt;
           System.out.println(product + ", Quantity: " + quantity);
           System.out.println("total price : "+ (itemsQunt *  product.getPrice()));
       }
	  }
   

	public double getTotalPrice() {
		double totalPrice = 0.0; 
		for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += product.getPrice() * quantity;
        }
		
		return totalPrice;

	}

	public boolean isEmpty() {
		 
		return items.isEmpty() ;
	}

	public void clearCart() {
		items.clear();
	}

}
