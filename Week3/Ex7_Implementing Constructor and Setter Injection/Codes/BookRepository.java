package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public BookRepository() {
        System.out.println("[Repository Bean] BookRepository created.");
    }

    public void fetchBooks() {
        System.out.println("[Repository] Fetching books from the database...");
    }
}
