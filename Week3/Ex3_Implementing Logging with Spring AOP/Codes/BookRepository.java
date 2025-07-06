package com.library.repository;

public class BookRepository {
    public BookRepository() {
        System.out.println("[Bean Initialized] BookRepository instantiated.");
    }

    public void fetchBooks() {
        System.out.println("[Bean Method] BookRepository: Fetching books from the database...");
    }
}
