package com.booleanuk.core;

public class Article extends Item{

    Author this_author;
    public Article(String title) {
        super(title);
    }

    public Article(String title, Author author) {
        super(title);
        this.this_author = author;
    }
}
