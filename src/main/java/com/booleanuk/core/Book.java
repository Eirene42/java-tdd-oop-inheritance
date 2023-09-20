package com.booleanuk.core;

public class Book extends Item{

    Author this_author;
    public Book(String title) {
        super(title);
    }

    public Book(String title, Author author) {
        super(title);
        this.this_author = author;
    }
}
