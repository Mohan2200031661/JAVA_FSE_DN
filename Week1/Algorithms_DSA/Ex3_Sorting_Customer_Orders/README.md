# 📦 Exercise 3: Sorting Customer Orders

## 🚀 Overview

This project demonstrates how to sort **customer orders by total price** in an e-commerce platform. It compares two sorting algorithms — **Bubble Sort** and **Quick Sort** — in terms of performance and use cases.

---

## 📘 1. Understanding Sorting Algorithms

### 🔹 Bubble Sort
- A simple comparison-based algorithm.
- Repeatedly swaps adjacent elements if they are in the wrong order.
- **Inefficient** for large datasets due to quadratic time complexity.

### 🔹 Quick Sort
- A divide-and-conquer algorithm.
- Selects a pivot and partitions the array into subarrays.
- **Efficient and widely used** due to its average-case performance and in-place sorting.

| Feature                       | **Bubble Sort**           | **Quick Sort**                   |
| ----------------------------- | ------------------------- | -------------------------------- |
| **Best Case Time**            | O(n)                      | O(n log n)                       |
| **Average Case Time**         | O(n²)                     | O(n log n)                       |
| **Worst Case Time**           | O(n²)                     | O(n²) *(rare, with poor pivots)* |
| **Space Complexity**          | O(1)                      | O(log n) (due to recursion)      |
| **Stable Sort**               | ✅ Yes                     | ❌ No (not guaranteed)            |
| **In-place Sort**             | ✅ Yes                     | ✅ Yes                            |
| **Ease of Implementation**    | ✅ Very Easy               | ❌ Moderate                       |
| **Performance on Large Data** | ❌ Poor                    | ✅ Excellent                      |
| **Use Case**                  | Educational, small arrays | Real-world apps, large datasets  |


---

## 🛠️ 2. Setup

### 🔹 Order Class
```java
class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int id, String name, double price) {
        this.orderId = id;
        this.customerName = name;
        this.totalPrice = price;
    }
}
