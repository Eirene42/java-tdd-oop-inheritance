package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LibradyTest {

    @Test
    public void addToStock() {
        Library library = new Library();
        library.setItems(new ArrayList<>());

        Item article = new Article("JUnit Rocks");
        Item book = new Book("JUnit Rocks");
        Item newspaper = new Newspaper("JUnit Rocks");

        library.addToStock(article);
        library.addToStock(book);
        library.addToStock(newspaper);

        Assertions.assertEquals(3, library.getItems().size());
        Assertions.assertTrue(library.getItems().contains(book));
        Assertions.assertTrue(library.getItems().contains(newspaper));
        Assertions.assertTrue(library.getItems().contains(article));

        Author author = new Author("Someone", "telephone", "someone@sth.com");
        Item article2 = new Article("Article with 3 parts", author);
        Item book2 = new Book("Book with 3 parts", author);

        library.addToStock(article2);
        library.addToStock(book2);

        Assertions.assertEquals(5, library.getItems().size());
        Assertions.assertTrue(library.getItems().contains(book2));
        Assertions.assertTrue(library.getItems().contains(article2));
    }

    @Test
    public void checkInTest() {
        Library library = new Library();
        library.setItems(new ArrayList<>());

        Item book = new Book("Book");
        Item newspaper = new Newspaper("Newspaper");

        library.addToStock(book);
        library.addToStock(newspaper);

        Assertions.assertEquals("item is not part of the library's collection", library.checkInItem("Article"));
        Assertions.assertEquals("item is not currently on loan", library.checkInItem("Book"));
        Assertions.assertEquals("newspapers are not available for loan", library.checkInItem("Newspaper"));

        book.setOnLoan(true);
        Assertions.assertEquals("item has been checked in", library.checkInItem("Book"));

        Author author = new Author("Someone", "telephone", "someone@sth.com");
        Item article2 = new Article("Article with 3 parts", author);
        Item book2 = new Book("Book with 3 parts", author);

        library.addToStock(article2);
        library.addToStock(book2);

        Assertions.assertEquals("item is not part of the library's collection", library.checkInItem("Newspaper with 3 parts"));
        Assertions.assertEquals("item is not currently on loan", library.checkInItem("Article with 3 parts"));
        Assertions.assertEquals("item is not currently on loan", library.checkInItem("Book with 3 parts"));

        article2.setOnLoan(true);
        Assertions.assertEquals("item has been checked in", library.checkInItem("Article with 3 parts"));
    }

    @Test
    public void checkOutTest() {
        Library library = new Library();
        library.setItems(new ArrayList<>());

        Item book = new Book("Book");
        Item newspaper = new Newspaper("Newspaper");

        library.addToStock(book);
        library.addToStock(newspaper);

        Assertions.assertEquals("item is not part of the library's collection", library.checkOutItem("Article"));
        Assertions.assertEquals("item has been checked out", library.checkOutItem("Book"));
        Assertions.assertEquals("newspapers are not available for loan", library.checkOutItem("Newspaper"));

        book.setOnLoan(true);
        Assertions.assertEquals("item is currently on loan", library.checkOutItem("Book"));

        Author author = new Author("Someone", "telephone", "someone@sth.com");
        Item article2 = new Article("Article with 3 parts", author);
        Item book2 = new Book("Book with 3 parts", author);

        library.addToStock(article2);
        library.addToStock(book2);

        Assertions.assertEquals("item is not part of the library's collection", library.checkOutItem("Newspaper with 3 parts"));
        Assertions.assertEquals("item has been checked out", library.checkOutItem("Article with 3 parts"));
        Assertions.assertEquals("item has been checked out", library.checkOutItem("Book with 3 parts"));

        article2.setOnLoan(true);
        Assertions.assertEquals("item is currently on loan", library.checkOutItem("Article with 3 parts"));
    }
}
