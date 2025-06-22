# 📈 Exercise 7: Financial Forecasting

## 🚀 Overview

This project implements a **financial forecasting tool** that predicts future values based on past growth rates using **recursive algorithms**. It demonstrates how recursion can simplify complex calculations and highlights optimization techniques.

---

## 📘 1. Understanding Recursive Algorithms

### 🔹 What is Recursion?

- **Recursion** is a programming technique where a function calls itself to solve smaller instances of a problem.
- It is especially useful for problems that can be divided into similar subproblems.
- Recursive solutions are often **more intuitive and concise** compared to iterative solutions.

### 🔹 Example: Future Value Calculation

Future Value \( FV \) after \( n \) periods with growth rate \( r \) and initial value \( P \) can be expressed recursively as:

\[
FV(n) = FV(n-1) \times (1 + r)
\]

With base case:

\[
FV(0) = P
\]


---

## ⚡ Optimization: Avoid Excessive Computation

### 1. Iterative Approach (Improved Space Complexity)

```java
public static double futureValueIterative(double principal, double growthRate, int periods) {
    double result = principal;
    for (int i = 0; i < periods; i++) {
        result *= (1 + growthRate);
    }
    return result;
}



