package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[DI] BookRepository injected.");
    }

    public void displayBooks() {
        System.out.println("[Service] Displaying books:");
        bookRepository.fetchBooks();
    }
}
