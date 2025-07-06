package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public BookService() {
        System.out.println("[Bean Initialized] BookService instantiated.");
    }
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("[Dependency Injection] Injecting BookRepository into BookService.");
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        System.out.println("[Bean Method] BookService: Displaying books.");
        bookRepository.fetchBooks();
    }
}
