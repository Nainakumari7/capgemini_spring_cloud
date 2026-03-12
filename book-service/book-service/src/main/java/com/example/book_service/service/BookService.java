package com.example.book_service.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.book_service.model.Book;
import com.example.book_service.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo){
        this.repo=repo;
    }

    public List<Book> getAll(){
        return repo.findAll();
    }

    public Book getById(Long id){
        return repo.findById(id).orElse(null);
    }

    public Book save(Book book){
        return repo.save(book);
    }

    public Book update(Long id,Book book){
        book.setId(id);
        return repo.save(book);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}