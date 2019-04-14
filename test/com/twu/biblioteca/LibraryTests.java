package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class LibraryTests {
    private Library library;

    @Before
    public void setUp() {
        this.library = new Library();
    }

    @Test
    public void welcomeMessageShouldReturnMessage() {
        //Arrange
        String message = "Hello World!";
        //Act
        library.setWelcomeMessage(message);
        //Assert
        assertEquals("Hello World!", library.getWelcomeMessage());
    }

    @Test
    public void getAllBooksShouldReturnListOfBooks() {
        //Act
        ArrayList<Book> results = library.getAllBooks();
        //Assert
        assertThat(results.get(0).getTitle(), is("Seven Languages in Seven Weeks"));
        assertThat(results.get(0).getAuthor(), is("Bruce A. Tate"));
        assertThat(results.get(0).getPublicationDate(), is("2010"));
        assertThat(results.get(1).getTitle(), is("Testing Extreme Programming"));
        assertThat(results.get(1).getAuthor(), is("Lisa Crispin"));
        assertThat(results.get(1).getPublicationDate(), is("2003"));
        assertThat(results.get(2).getTitle(), is("Ubuntu Kung Fu"));
        assertThat(results.get(2).getAuthor(), is("Keir Thomas"));
        assertThat(results.get(2).getPublicationDate(), is("2008"));
    }

    @Test
    public void getAllBooksShouldReturnListOfAllBooks() {
        //Act
        ArrayList<Book> results = library.getAllBooks();
        //Assert
        assertThat(results.size(), is(3));
    }

    @Test
    public void getAvailableBooksShouldReturnUncheckedBooks() {
        //Arrange
        library.checkOutBook("Seven Languages in Seven Weeks");
        //Act
        ArrayList<Book> results = library.getAvailableBooks();
        //Assert
        assertThat(results.size(), is(2));
        assertThat(results.get(0).getTitle(), is("Testing Extreme Programming"));
        assertThat(results.get(1).getTitle(), is("Ubuntu Kung Fu"));
    }

    @Test
    public void getBookShouldReturnBook() {
        //Act
        Book result = library.getBook(0);
        //Assert
        assertThat(result.getTitle(), is("Seven Languages in Seven Weeks"));
        assertThat(result.getAuthor(), is("Bruce A. Tate"));
        assertThat(result.getPublicationDate(), is("2010"));

    }

    @Test
    public void checkOutBookShouldMarkBookAsCheckedOut() {
        //Act
        library.checkOutBook("Seven Languages in Seven Weeks");
        //Assert
        assertThat(library.getBook(0).isCheckedOut(), is(true));
    }

    @Test
    public void checkOutBookShouldReturnSuccessMessage() {
        //Act
        String result = library.checkOutBook("Seven Languages in Seven Weeks");
        //Assert
        assertEquals("Thank you! You have successfully checked out 'Seven Languages in Seven Weeks'", result);
    }

    @Test
    public void checkOutUnavailableBookShouldReturnBookIsNotAvailable() {
        //Act
        library.checkOutBook("Seven Languages in Seven Weeks");
        String result = library.checkOutBook("Seven Languages in Seven Weeks");
        //Assert
        assertThat(result, is("Sorry, this book is not available."));
    }

    @Test
    public void returnBookShouldReturnBookToLibraryCollection() {
        //Act
        library.returnBook("Seven Languages in Seven Weeks");
        ArrayList<Book> results = library.getAvailableBooks();
        //Assert
        assertThat(results.size(), is(3));
        assertThat(results.get(0).getTitle(), is("Seven Languages in Seven Weeks"));
        assertThat(results.get(1).getTitle(), is("Testing Extreme Programming"));
        assertThat(results.get(2).getTitle(), is("Ubuntu Kung Fu"));
    }

}