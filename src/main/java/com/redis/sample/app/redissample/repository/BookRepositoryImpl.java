package com.redis.sample.app.redissample.repository;

import com.redis.sample.app.redissample.model.Book;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private RedisTemplate<String, Book> redisTemplate;
    private HashOperations hashOperations;

    private ListOperations<Long, Book> listOps;

    private final static String ENTITY = "BOOK";


    public BookRepositoryImpl(RedisTemplate<String, Book> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = this.redisTemplate.opsForHash();
    }
    private AtomicLong id = new AtomicLong();


    @Override
    public Book create(Book book) {
        book.setId(id.incrementAndGet());
        hashOperations.put(ENTITY, book.getId(), book);
        return book;
    }

    @Override
    public Book update(Book book) {
        hashOperations.put(ENTITY, book.getId(), book);
        return book;
    }

    @Override
    public Book get(Long id) {
        return (Book) hashOperations.get(ENTITY, id);
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();

        Map<Long, Book> entries= hashOperations.entries(ENTITY);
        if (entries != null && entries.size() > 0) {
            books = entries.values().stream().collect(Collectors.toList());
        }
        return books;
    }

    @Override
    public void delete(Long id) {
        hashOperations.delete(ENTITY, id);
    }
}
