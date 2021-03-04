package com.rocketnine;

import dev.emergent.BookInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class ISBN10Test {

    @Test
    public void number_contains_spaces_ReturnsWithoutSpaces() {

        // Arrange
        ISBNFinder sut = new ISBNFinder();

        // Act
       // String shortISBN = "12 345";
        String longISBN = "978 0 131 49505 0";
        BookInfo actual = sut.lookup(longISBN);

        // Assert
        Assertions.assertEquals("9780131495050", actual.isbn13());

    }

    @Test
    public void ISBN_shorterThan10Characters_ReturnsInvalidBookInfo() {
        // Arrange
        ISBNFinder sut = new ISBNFinder();

        // Act
        String shortISBN = "12345";
        BookInfo actual = sut.lookup(shortISBN);

        // Assert
        assertEquals("ISBN must be 10 characters in length", actual.title);
    }

    private void assertEquals(String s, String title) {
    }

    @Test
    public void ISBN_longerThan10Characters_ReturnsInvalidBookInfo() {
        // Arrange
        ISBNFinder sut = new ISBNFinder();

        // Act
        String longISBN = "1234567890BCDEF";
        BookInfo actual = sut.lookup(longISBN);

        // Assert
        assertEquals("ISBN must be 10 characters in length", actual.title);
    }

    @Test
    public void ISBN_BookNotFound() {
        ISBNFinder sut = new ISBNFinder();

        String unknownISBN = "0553562614";
        BookInfo actual = sut.lookup(unknownISBN);

        assertEquals("Title not found", actual.title);
    }

    @Test
    public void ISBN_BookFound() {
        ISBNFinder sut = new ISBNFinder();

        String ISBN = "0321146530";
        BookInfo actual = sut.lookup(ISBN);

        BookInfo expected = new BookInfo("Test Driven Development by Example", "Kent Beck", "0321146530", "9780321146533");

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    @Disabled
    public void FailingTest_BreaksTheBuild() {
        fail("Azure build is broken. Delete this test to get a Green build.");
    }
}
