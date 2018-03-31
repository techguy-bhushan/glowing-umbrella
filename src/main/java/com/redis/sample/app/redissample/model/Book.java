package com.redis.sample.app.redissample.model;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class Book implements Serializable{
    private Long id;
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private String isbn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
