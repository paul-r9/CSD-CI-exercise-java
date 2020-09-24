package com.rocketnine;

import dev.emergent.BookInfo;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ISBN10Test {

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
    public void ignore_spaces_in_ISBN10() {
        ISBNFinder sut = new ISBNFinder();

        String ISBN = "03 211 465 3 0";
        BookInfo actual = sut.lookup(ISBN);

        BookInfo expected = new BookInfo("Test Driven Development by Example", "Kent Beck", "0321146530", "9780321146533");

        assertNotNull(actual);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void ignore_dashes_in_ISBN10() {
        ISBNFinder sut = new ISBNFinder();

        String ISBN = "03-211-465-30";
        BookInfo actual = sut.lookup(ISBN);

        BookInfo expected = new BookInfo("Test Driven Development by Example", "Kent Beck", "0321146530", "9780321146533");

        assertNotNull(actual);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void invalidChecksum_Returns_BookNotFound() {
        ISBNFinder sut = new ISBNFinder();

        String ISBN = "0321146531";
        BookInfo actual = sut.lookup(ISBN);

        assertNotNull(actual);
        assertEquals("Invalid ISBN", actual.title);
    }

}
