package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService() {
        System.out.println("[Service Bean] BookService created.");
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("[DI] BookRepository injected into BookService.");
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        System.out.println("[Service] Displaying books:");
        bookRepository.fetchBooks();
    }
}
