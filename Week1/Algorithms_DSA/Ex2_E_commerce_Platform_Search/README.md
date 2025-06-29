# 🔍 E-commerce Platform Search Function

## 🚀 Overview

This project demonstrates the implementation of **search functionality** in an e-commerce platform using **Linear Search** and **Binary Search**. It highlights the importance of **asymptotic analysis** for choosing the right algorithm for performance-critical systems.

---

## 📘 1. Understanding Asymptotic Notation

### 🔹 What is Big O Notation?

Big O notation describes how the **runtime** or **space** requirements of an algorithm grow relative to input size `n`. It helps in comparing the **efficiency** of algorithms.

- **Big O (O)**: Upper bound (worst-case performance)
- **Omega (Ω)**: Lower bound (best-case performance)
- **Theta (Θ)**: Tight bound (average-case performance)

### 🔹 Scenarios for Search Operations

| Scenario      | Linear Search | Binary Search       |
|---------------|----------------|----------------------|
| Best Case     | O(1)           | O(1) (middle element) |
| Average Case  | O(n/2) = O(n)  | O(log n)             |
| Worst Case    | O(n)           | O(log n)             |

---

## 🛠️ 2. Setup

### 🔹 Product Class
```java
class Product {
    int productId;
    String productName;
    String category;

    public Product(int id, String name, String cat) {
        this.productId = id;
        this.productName = name;
        this.category = cat;
    }
}
