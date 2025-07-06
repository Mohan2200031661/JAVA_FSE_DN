package com.library.repository;

public class BookRepository {
        public BookRepository() {
            System.out.println("[IoC] BookRepository created.");
        }

        public void fetchBooks() {
            System.out.println("[Repository] Fetching books from database...");
        }

}
