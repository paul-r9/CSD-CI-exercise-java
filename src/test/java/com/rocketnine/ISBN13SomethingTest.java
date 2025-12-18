package com.rocketnine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ISBN13SomethingTest {
    @Test
    public void ISBN_shorterThan13Characters() {
        // Arrange
        // ISBNFinder sut = new ISBNFinder();

        // Act
        String shortISBN = "12345";
        boolean actual = ISBNFinder.isIt13(shortISBN);

        // Assert
        assertFalse(actual);
    }

    @Test
    public void ISBN_greaterThan13Characters() {
        // Arrange
        // ISBNFinder sut = new ISBNFinder();

        // Act
        String shortISBN = "123456789101112";
        boolean actual = ISBNFinder.isIt13(shortISBN);

        // Assert
        assertFalse(actual);
    }

    @Test
    public void ISBN_equalsTo13Characters() {
        // ISBNFinder sut = new ISBNFinder();

        String shortISBN = "9780593959312";
        boolean actual = ISBNFinder.isIt13(shortISBN);

        assertTrue(actual);
    }


}
