# ✅ Exercise 5: Task Management System

## 🚀 Overview

This project implements a **Task Management System** using a **Singly Linked List**. It supports operations like:

- **Adding tasks**
- **Searching for tasks**
- **Traversing tasks**
- **Deleting tasks**

This system is ideal for dynamic task lists where the number of tasks is not fixed.

---

## 📘 1. Understanding Linked Lists

### 🔹 Types of Linked Lists

| Type                 | Description |
|----------------------|-------------|
| **Singly Linked List** | Each node points to the next. Traversal is one-way. |
| **Doubly Linked List** | Each node points to both previous and next. Supports bidirectional traversal. |
| **Circular Linked List** | Last node links to the first node. Can be singly or doubly linked. |

### 🔹 When to Use Linked Lists

- When frequent **insertions/deletions** are required.
- When **dynamic memory allocation** is preferred.
- When array resizing is expensive or not feasible.

---

### 📊 Time Complexity Analysis
| Operation      | Time Complexity | Notes                             |
| -------------- | --------------- | --------------------------------- |
| Add Task       | O(n)            | Add at end (traverse required)    |
| Search Task    | O(n)            | Linear search by ID               |
| Traverse Tasks | O(n)            | Visit each node once              |
| Delete Task    | O(n)            | Need to find and update reference |

### 🔍 Linked Lists vs Arrays

| Feature                  | Linked List                | Array                |
| ------------------------ | -------------------------- | -------------------- |
| Memory Allocation        | Dynamic                    | Fixed size           |
| Insertion (middle/start) | O(1) (with pointer)        | O(n)                 |
| Deletion (middle/start)  | O(1) (with pointer)        | O(n)                 |
| Random Access            | ❌ Not supported            | ✅ O(1)               |
| Memory Overhead          | Higher (pointers per node) | Lower (compact data) |


## 🛠️ 2. Setup

### 🔹 Task Class
```java
class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int id, String name, String status) {
        this.taskId = id;
        this.taskName = name;
        this.status = status;
    }
}
