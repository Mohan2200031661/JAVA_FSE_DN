package ims;
import java.util.HashMap;

public class Inventory {
	private HashMap<String, Product> products;

	public Inventory() {
		products = new HashMap<>();
	}

	public void addProduct(Product product) {
		if (products.containsKey(product.getProductId())) {
			System.out.println("Product already exists.");
		} else {
			products.put(product.getProductId(), product);
			System.out.println("Product added successfully.");
		}
	}

	public void updateProduct(String productId, String name, Integer quantity, Double price) {
		if (products.containsKey(productId)) {
			Product product = products.get(productId);
			if (name != null)
				product.setProductName(name);
			if (quantity != null)
				product.setQuantity(quantity);
			if (price != null)
				product.setPrice(price);
			System.out.println("Product updated successfully.");
		} else {
			System.out.println("Product not found.");
		}
	}

	public void deleteProduct(String productId) {
		if (products.containsKey(productId)) {
			products.remove(productId);
			System.out.println("Product deleted successfully.");
		} else {
			System.out.println("Product not found.");
		}
	}

	public void displayInventory() {
		if (products.isEmpty()) {
			System.out.println("Inventory is empty.");
		} else {
			for (Product product : products.values()) {
				System.out.println(product);
			}
		}
	}
}
