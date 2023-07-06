package OnlineShoppingSystemFileIO;

import java.util.Scanner;

public class ShoppingSystemMain {

	public static void main(String[] args) {

		ProductCatalog productCatalog = new ProductCatalog();

		ShoppingCart shoppingCart = new ShoppingCart();

		OrderHistory orderHistory = new OrderHistory();
		
		

		Scanner scanner = new Scanner(System.in);

		int choice;

		do {
			System.out.println(" Enter the your choice :");
			System.out.println("1. Create a new file to store the data :");
			System.out.println("2. Load the existing product file");
			System.out.println("3. Create new product :");
			System.out.println("4. Display all abailable the products :");
			System.out.println("5. Add product to Cart :");
			System.out.println("6. Show items in the Cart :");
			System.out.println("7. Remove the items from Cart :");
			System.out.println("8. Order the Products: ");
			System.out.println("9. Story order data to a file :");
			System.out.println("10. Exit");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter file name :");
				String fileName = scanner.nextLine();
				productCatalog.saveProduct(fileName);
				break;
				
			case 2: 
				System.out.println("Enter the Product file name :");
				String fileName2 = scanner.nextLine();
				productCatalog.loadProducts(fileName2);
		        System.out.println("Enter the loaded orderHistory fileName");
		        String fileName3 = scanner.nextLine();
		        orderHistory.loadOrderHistory(fileName3);
			case 3:
				System.out.println("Enter the Product name :");
				String name = scanner.nextLine();
				System.out.println("Enter the Product description :");
				String description = scanner.nextLine();
				System.out.println("Enter the Product price :");
				double price = scanner.nextDouble();
				System.out.println("Enter the Product quentity :");
				int quentity = scanner.nextInt();
				Product product = new Product(name, description, price, quentity);
				productCatalog.addProducts(product);
				System.out.println("Product added to file successful");
				break;

			case 4:
				System.out.println("All the Products available for Shopping ");
				productCatalog.display();
				break;

			case 5:
				System.out.println("Enter Product Name to add Shopping cart :");
				String productName = scanner.nextLine();
				Product product1 = productCatalog.getProduct(productName);
				if (product1 != null) {
					System.out.println("Enter the Product quentity :");
					int productQuentity = scanner.nextInt();
					int netQnt = product1.getQuantity();
					if (productQuentity <= netQnt) {
						shoppingCart.addItem(product1, productQuentity);
						System.out.println("product add to cart successful");
						
					} else {
						System.out.println("Quentity is not abailable");
					}
				} else {
					System.out.println("product is not there ");
				}
				break;
			case 6:
				System.out.println("your bag items is :");
				shoppingCart.cartDisplay();
                break;
			case 7:
				System.out.println("Enter the Product name to remove from shopping card");
				String pName = scanner.nextLine();
				Product product2 = productCatalog.getProduct(pName);
				System.out.println("Enter the product quentity for remove from shoppingcart: ");
				int qunt =scanner.nextInt();
				if (product2 != null || qunt <= product2.getQuantity()) {
					 
					shoppingCart.removeItem(product2,qunt);
					System.out.println("product remove to cart successful");
				} else {
					System.out.println("product is not there ");
				}
				break;

			case 8:
				System.out.println("Placing an order...");
				String prName = scanner.nextLine();
				if (shoppingCart.isEmpty()) {
                    System.out.println("Shopping cart is empty. Cannot place an order.");
                } else {
                    Order order = new Order(shoppingCart.getItems(), shoppingCart.getTotalPrice());
                    orderHistory.addOrder(order);
                    System.out.println("Order placed successfully.");
                    System.out.println("Order Confirmation Number: " + order.getConfirmationNumber());
                    System.out.println("Total Price: $" + order.getTotalPrice());

                    shoppingCart.clearCart();
                }
                
				break;
			 
            case 9:
                System.out.print("Enter the file name to save the product file: ");
                String productFileNames = scanner.nextLine();
                productCatalog.saveProduct(productFileNames);

                System.out.print("Enter the file name to save the order history: ");
                String orderFileNames = scanner.nextLine();
                orderHistory.saveOrderHistory(orderFileNames);

                System.out.println("Exiting the program. Thank you for using the Online Shopping System!");
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid option. Please try again.");
			}

			System.out.println();

		} while (choice != 9);

		scanner.close();
	}
}
