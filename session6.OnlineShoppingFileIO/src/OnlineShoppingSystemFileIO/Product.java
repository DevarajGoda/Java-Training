package OnlineShoppingSystemFileIO;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String description;
	
	private double price;
	
	private int quantity;

	public void equals() {
		
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}

	public Product(String name, String description, double price, int quantity) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	public boolean equals(Object object) {
		if(this == object)
			return true;
		if(object == null || getClass() != object.getClass())
			return false;
		Product newProduct =(Product) object;
		return Objects.equals(name, newProduct.name);
	}

	public Product() {
		 
	}

	 
}
