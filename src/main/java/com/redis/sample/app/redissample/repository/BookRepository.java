package com.redis.sample.app.redissample.repository;

import com.redis.sample.app.redissample.model.Book;

import java.util.List;

public interface BookRepository {
    Book create(Book book);
    Book update(Book book);
    Book get(Long id);
    List<Book> findAll();
    void delete(Long id);
}
