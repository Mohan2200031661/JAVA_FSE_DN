package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        System.out.println("[Application] Initializing Spring context...");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("[Application] Getting BookService bean...");
        BookService bookService = context.getBean("bookService", BookService.class);

        System.out.println("[Application] Calling displayBooks...");
        bookService.displayBooks();

        System.out.println("[Application] Done.");
    }
}