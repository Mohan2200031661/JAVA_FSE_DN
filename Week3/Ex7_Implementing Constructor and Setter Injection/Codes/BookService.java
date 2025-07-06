package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private String message; // for constructor injection
    private BookRepository bookRepository; // for setter injection

    // Constructor injection
    public BookService(String message) {
        this.message = message;
        System.out.println("[Constructor Injection] Message: " + message);
    }

    // Setter injection
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("[Setter Injection] BookRepository injected.");
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        System.out.println("[Service] " + message);
        bookRepository.fetchBooks();
    }
}
