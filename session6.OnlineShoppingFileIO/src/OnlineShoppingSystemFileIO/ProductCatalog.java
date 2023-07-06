package OnlineShoppingSystemFileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ProductCatalog {
	
	private HashMap<String, Product> products;

	public HashMap<String, Product> getProduct() {
		return products;
	}

	public ProductCatalog(HashMap<String, Product> products) {
		super();
		this.products = products;
	}

	public void setProduct(HashMap<String, Product> product) {
		this.products = product;
	}
	
	public ProductCatalog() {
		products = new HashMap<>();
	}

	public void display() {
		for(Product product : products.values()) {
			System.out.println(product);
		}
	}
 
	public void saveProduct(String fileName) {
		
		try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(products);
            objectOut.close();
            fileOut.close();
            System.out.println("Product catalog saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving product catalog: " + e.getMessage());
        }
		
	}
	
	  public void loadProducts(String fileName) {
	        try {
	            FileInputStream fileIn = new FileInputStream(fileName);
	            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
	            products = (HashMap<String, Product>) objectIn.readObject();
	            objectIn.close();
	            fileIn.close();
	            System.out.println("Products loaded successfully.");
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error loading Products : " + e.getMessage());
	        }
	    }
	
	public void addProducts(Product product) {
		products.put(product.getName(), product);
	}
	
	Product getProduct(String name) {
		return products.get(name);
		
	}
}
