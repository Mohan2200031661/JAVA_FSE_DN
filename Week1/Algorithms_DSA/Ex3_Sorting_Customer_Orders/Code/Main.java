package ecc;

public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("ORD001", "Amit Kumar", 1540.0),
            new Order("ORD002", "Priya Singh", 2650.0),
            new Order("ORD003", "Rahul Verma", 890.0),
            new Order("ORD004", "Neha Mehta", 4300.0),
            new Order("ORD005", "Arjun Reddy", 3100.0)
        };

        SortCustomers.bubbleSort(orders);
        System.out.println("Sorted by Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        Order[] orders2 = {
            new Order("ORD001", "Amit Kumar", 1540.0),
            new Order("ORD002", "Priya Singh", 2650.0),
            new Order("ORD003", "Rahul Verma", 890.0),
            new Order("ORD004", "Neha Mehta", 4300.0),
            new Order("ORD005", "Arjun Reddy", 3100.0)
        };

        SortCustomers.quickSort(orders2, 0, orders2.length - 1);
        System.out.println("\nSorted by Quick Sort:");
        for (Order order : orders2) {
            System.out.println(order);
        }
    }
}

