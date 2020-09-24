package com.rocketnine;

import dev.emergent.BookInfo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
    public void ISBN_longerThan13Characters_ReturnsInvalidBookInfo() {
        // Arrange
        ISBNFinder sut = new ISBNFinder();

        // Act
        String longISBN = "1234567890BCDEF";
        BookInfo actual = sut.lookup(longISBN);

        // Assert
        assertEquals("ISBN must be 13 characters in length", actual.title);
    }

    @Test
    public void ISBN_validCheckSum_ReturnsValidLookup() {
        ISBNFinder sut = new ISBNFinder();

        String validCheckSumISBN = "9780201485678";

        BookInfo actual = sut.lookup(validCheckSumISBN);

        assertEquals("ISBN is NOT Valid CheckSum", actual.title);
    }
}
