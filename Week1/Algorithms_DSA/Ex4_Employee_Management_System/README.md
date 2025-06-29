# 🧑‍💼 Exercise 4: Employee Management System

## 🚀 Overview

This project involves building an **Employee Management System** using **arrays** to store and manage employee records. It includes operations such as **adding**, **searching**, **traversing**, and **deleting** employees.

---

## 📘 1. Understanding Array Representation

### 🔹 How Arrays Are Represented in Memory:

- Arrays are **contiguous blocks of memory**.
- Every element has the same size and type.
- Indexed access allows **constant-time retrieval (O(1))**.

### 🔹 Advantages of Arrays:

| Advantage              | Explanation                                       |
|------------------------|---------------------------------------------------|
| Fast Access            | Direct access via index (O(1))                    |
| Memory Efficiency      | No overhead of additional references or objects   |
| Simplicity             | Easy to implement and understand                  |

---
### Time Complexity Analysis

| Operation | Time Complexity | Explanation                             |
| --------- | --------------- | --------------------------------------- |
| Add       | O(1)            | Add at end (no shifting required)       |
| Search    | O(n)            | Linear scan to find employee by ID      |
| Traverse  | O(n)            | Visit each element once                 |
| Delete    | O(n)            | Find + shift elements to maintain order |

### Limitations of Arrays

| Limitation                      | Description                                               |
| ------------------------------- | --------------------------------------------------------- |
| Fixed Size                      | Cannot dynamically grow without resizing manually         |
| Insertion at Arbitrary Position | Requires shifting elements — costly for large arrays      |
| Deletion Overhead               | Requires shifting to fill gaps, unlike linked structures  |
| Sparse Data Handling            | Wasteful if only a few elements are used in a large array |

---

## 🛠️ 2. Setup

### 🔹 Employee Class
```java
class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int id, String name, String position, double salary) {
        this.employeeId = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}
