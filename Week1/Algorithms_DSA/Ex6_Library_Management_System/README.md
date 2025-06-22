# 📚 Exercise 6: Library Management System

## 🚀 Overview

This project implements a **Library Management System** that allows users to search for books by **title** or **author** using:

- **Linear Search**
- **Binary Search** (on sorted data)

This exercise compares the performance of both search algorithms based on data order and size.

---

## 📘 1. Understanding Search Algorithms

| Algorithm       | Description |
|-----------------|-------------|
| **Linear Search** | Checks each element one-by-one until a match is found or the list ends. |
| **Binary Search** | Efficient algorithm that repeatedly divides a **sorted** list in half to find a match. |

### 📊 Time Complexity Analysis
| Algorithm         | Best Case | Average Case | Worst Case | Requirement        |
| ----------------- | --------- | ------------ | ---------- | ------------------ |
| **Linear Search** | O(1)      | O(n)         | O(n)       | No order required  |
| **Binary Search** | O(1)      | O(log n)     | O(log n)   | Must be **sorted** |

### 🤔 When to Use Which Algorithm?
| Situation                              | Recommended Algorithm |
| -------------------------------------- | --------------------- |
| Small dataset or unsorted data         | ✅ Linear Search       |
| Large dataset and already sorted       | ✅ Binary Search       |
| Real-time addition without sorting     | ✅ Linear Search       |
| Static or infrequently updated dataset | ✅ Binary Search       |

---



## 🛠️ 2. Setup

### 🔹 Book Class
```java
class Book {
    int bookId;
    String title;
    String author;

    public Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }
}
