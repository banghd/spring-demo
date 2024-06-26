package com.example.book_by_spring.controller;

import com.example.book_by_spring.model.Book;
import com.example.book_by_spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    // create a book
    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookService.save(book);
    }

    // update a book
    @PutMapping
    public Book update(@RequestBody Book book) {
        return bookService.save(book);
    }

    // delete a book
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @GetMapping("/find/title/{title}")
    public List<Book> findByTitle(@PathVariable String title) {
        return bookService.findByTitle(title);
    }

    @GetMapping("/find/price-larger")
    public List<Book> findByPublishedDateAfter(
            @RequestParam("price") int price
    ){
        return bookService.findBookHasPriceLarger(price);
    }
}
