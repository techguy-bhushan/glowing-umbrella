package com.redis.sample.app.redissample.api;

import com.redis.sample.app.redissample.model.Book;
import com.redis.sample.app.redissample.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookApi {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping(consumes = "application/json")
    public ResponseEntity create(@Valid @RequestBody Book book) {
        if (book.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        book = bookRepository.create(book);
        return ResponseEntity.ok(book);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity update(@Valid @RequestBody Book book) {
        if (book.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        book = bookRepository.update(book);

        return book == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Book book = bookRepository.get(id);
        return book == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity get() {
        List<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        bookRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}