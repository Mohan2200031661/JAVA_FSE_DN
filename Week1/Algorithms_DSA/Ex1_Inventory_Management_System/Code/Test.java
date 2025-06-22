package ims;

public class Test {
 public static void main(String[] args) {
     Inventory inventory = new Inventory();

     Product product1 = new Product("P001", "Widget", 50, 9.99);
     Product product2 = new Product("P002", "Gadget", 30, 14.99);

     inventory.addProduct(product1);
     inventory.addProduct(product2);

     inventory.updateProduct("P001", null, 60, null);

     inventory.deleteProduct("P002");

     inventory.displayInventory();
 }
}

