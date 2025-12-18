package com.rocketnine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dev.emergent.BookInfo;

public class ISBN13Test {
    
    @Test
    public void ISBN_shorterThan13Characters_ReturnsInvalidBookInfo() {
        // Arrange
        ISBNFinder sut = new ISBNFinder();

        // Act
        String shortISBN = "12345";
        BookInfo actual = sut.lookup(shortISBN);

        // Assert
        assertEquals("ISBN must be 10 characters in length", actual.title);
    }

    @Test
    public void ISBN_BookFound() {
        ISBNFinder sut = new ISBNFinder();

        String ISBN = "9780131495050";
        BookInfo actual = sut.lookup(ISBN);

        BookInfo expected = new BookInfo("xUnit Test Patterns", "Gerard Meszaros", "0131495054", "9780131495050");
        assertEquals(expected.toString(), actual.toString());
    }
}
