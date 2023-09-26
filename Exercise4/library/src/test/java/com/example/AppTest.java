package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    // Tests of Book class
    @Test
    @DisplayName("Test that book returns title correctly")
    public void testGetTitle() {
        Book book = new Book("nimi", "kuvaus");
        assertEquals("nimi", book.getTitle());
    }

    @Test
    @DisplayName("Test that book returns genre correctly")
    public void testGetGenre() {
        Book book = new Book("nimi", "kuvaus", Book.Genre.SCIENCE_FICTION);
        assertEquals(Book.Genre.SCIENCE_FICTION, book.getGenre());
    }

    @Test
    @DisplayName("Test that book returns description correctly")
    public void testGetDescription() {
        Book book = new Book("nimi", "kuvaus");
        assertEquals("kuvaus", book.getDescription());
    }

    @Test
    @DisplayName("Test that book is set as borrowed")
    public void testSetBorrowed() {
        Book book = new Book("nimi", "kuvaus");
        assertEquals(false, book.isBorrowed());

        book.setBorrowed(true);
        assertEquals(true, book.isBorrowed());
    }

    @Test
    @DisplayName("Test if book is borrowed")
    public void testIsBorrowed() {
        Book book = new Book("nimi", "kuvaus");
        assertEquals(false, book.isBorrowed());

        book.setBorrowed(true);
        assertEquals(true, book.isBorrowed());
    }

    // Tests of Library class
    @Test
    @DisplayName("Test that book is added to library")
    public void testAddBook() {
        Library library = new Library("nimi", "osoite");
        Book book = new Book("nimi", "kuvaus");
        Book bookNull = null;

        library.addBook(book);
        assertEquals(book, library.getBookByIdx(0));

        library.addBook(bookNull);
        assertEquals(1, library.getAllBooks().size());
    }

    @Test
    @DisplayName("Test that book is retrieved correctly by index")
    public void testGetBookByIdx() {
        Library library = new Library("nimi", "osoite");
        Book book = new Book("nimi", "kuvaus");

        library.addBook(book);
        assertEquals(book, library.getBookByIdx(0));
    }

    @Test
    @DisplayName("Test that book can be borrowed")
    public void testBorrowBook() {
        Library library = new Library("nimi", "osoite");
        Book book = new Book("nimi", "kuvaus");

        library.addBook(book);
        library.borrowBook(0);
        assertEquals(true, library.getBookByIdx(0).isBorrowed());
    }

    @Test
    @DisplayName("Test that book can be returned")
    public void testReturnBook() {
        Library library = new Library("nimi", "osoite");
        Book book = new Book("nimi", "kuvaus");

        library.addBook(book);
        library.borrowBook(0);
        assertEquals(true, library.getBookByIdx(0).isBorrowed());

        library.returnBook(book);
        assertEquals(false, library.getBookByIdx(0).isBorrowed());
    }

    @Test
    @DisplayName("Test that all books are returned")
    public void testGetAllBooks() {
        Library library = new Library("nimi", "osoite");
        Book book = new Book("nimi", "kuvaus");

        library.addBook(book);
        assertEquals(1, library.getAllBooks().size());
    }

    @Test
    @DisplayName("Test that available books are returned")
    public void testGetAvailableBooks() {
        Library library = new Library("nimi", "osoite");
        Book book = new Book("nimi", "kuvaus");

        library.addBook(book);
        assertEquals(1, library.getAvailableBooks().size());

        library.borrowBook(0);
        assertEquals(0, library.getAvailableBooks().size());
    }

    @Test
    @DisplayName("Test that books by genre are returned correctly")
    public void testGetBooksByGenre() {
        Library library = new Library("nimi", "osoite");
        Book book = new Book("nimi", "kuvaus", Book.Genre.SCIENCE_FICTION);

        library.addBook(book);
        assertEquals(1, library.getBooksByGenre(Book.Genre.SCIENCE_FICTION).size());
        assertEquals(0, library.getBooksByGenre(Book.Genre.FANTASY).size());
    }

    @Test
    @DisplayName("Test that library by name is returned correctly")
    public void testGetName() {
        Library library = new Library("nimi", "osoite");
        assertEquals("nimi", library.getName());
    }

    @Test
    @DisplayName("Test that library by address is returned correctly")
    public void testGetAddress() {
        Library library = new Library("nimi", "osoite");
        assertEquals("osoite", library.getAddress());
    }

    @Test
    @DisplayName("Test that library is open")
    public void testIsOpen() {
        Library library = new Library("nimi", "osoite");
        assertEquals(false, library.isOpen());
    }

    @Test
    @DisplayName("Test that library is set open")
    public void testSetOpen() {
        Library library = new Library("nimi", "osoite");
        assertEquals(false, library.isOpen());

        library.setOpen(true);
        assertEquals(true, library.isOpen());
    }
}
