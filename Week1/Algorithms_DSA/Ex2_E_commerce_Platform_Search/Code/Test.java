package ecp;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
	public static void main(String[] args) {
     Product[] products = {
         new Product("P101", "Shoes", "Footwear"),
         new Product("P102", "T-Shirt", "Apparel"),
         new Product("P103", "Laptop", "Electronics"),
         new Product("P104", "Phone", "Electronics"),
         new Product("P105", "Jeans", "Apparel")
     };

     Product foundLinear = SearchImpl.linearSearch(products, "Shoes");
     
     if(foundLinear!=null)
     System.out.println(foundLinear.toString());
     else
    	 System.out.println("Product Not Found");

     Arrays.sort(products, Comparator.comparing(Product::getProductName));

     Product foundBinary = SearchImpl.binarySearch(products, "Laptop");
     
     System.out.println(foundBinary.toString());
 }
}
