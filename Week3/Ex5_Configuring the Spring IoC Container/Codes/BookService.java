package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public BookService() {
        System.out.println("[IoC] BookService created.");
    }

    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("[IoC] BookRepository injected into BookService.");
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        System.out.println("[Service] Displaying books:");
        bookRepository.fetchBooks();
    }
}
