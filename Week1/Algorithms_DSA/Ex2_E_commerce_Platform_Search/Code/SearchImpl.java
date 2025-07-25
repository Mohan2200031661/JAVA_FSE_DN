package ecp;

public class SearchImpl {

	public static Product linearSearch(Product[] products, String targetName) {
		for (Product product : products) {
			if (product.getProductName().equalsIgnoreCase(targetName)) {
				return product;
			}
		}
		return null;
	}

	public static Product binarySearch(Product[] products, String targetName) {
		int left = 0;
		int right = products.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			String midName = products[mid].getProductName();

			int comparison = midName.compareToIgnoreCase(targetName);
			if (comparison == 0) {
				return products[mid];
			} else if (comparison < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return null;
	}
}
