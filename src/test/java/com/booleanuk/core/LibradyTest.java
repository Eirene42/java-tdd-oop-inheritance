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
    }
}
