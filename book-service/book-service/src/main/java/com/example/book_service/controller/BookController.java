package com.example.book_service.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book_service.model.Book;
import com.example.book_service.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service){
        this.service=service;
    }

    @GetMapping
    public List<Book> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public Book create(@RequestBody Book book){
        return service.save(book);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id,@RequestBody Book book){
        return service.update(id,book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}