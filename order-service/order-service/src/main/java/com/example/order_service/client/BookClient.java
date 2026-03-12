package com.example.order_service.client;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.order_service.dto.BookDTO;

@FeignClient(name="book-service")
public interface BookClient {

    @GetMapping("/api/books")
    List<BookDTO> getAllBooks();

    @GetMapping("/api/books/{id}")
    BookDTO getBookById(@PathVariable Long id);

    @PostMapping("/api/books")
    BookDTO createBook(@RequestBody BookDTO book);

    @PutMapping("/api/books/{id}")
    BookDTO updateBook(@PathVariable Long id,@RequestBody BookDTO book);

    @DeleteMapping("/api/books/{id}")
    void deleteBook(@PathVariable Long id);
}
