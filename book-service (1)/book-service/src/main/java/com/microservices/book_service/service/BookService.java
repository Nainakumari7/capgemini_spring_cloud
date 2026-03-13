package com.microservices.book_service.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.book_service.entity.Book;
import com.microservices.book_service.repository.BookRepository;


@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    public Book addBook(Book book) {
        return repo.save(book);
    }

    public List<Book> getBooks() {
        return repo.findAll();
    }

    public Book updateBook(Book book) {
        return repo.save(book);
    }

    public void reduceStock(int id, int quantity) {

        Book book = repo.findById(id).orElse(null);

        if(book != null) {
            book.setStock(book.getStock() - quantity);
            repo.save(book);
        }
    }
}