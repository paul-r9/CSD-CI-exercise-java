package com.rocketnine;

import dev.emergent.BookInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ISBN13SomethingTest {
    @Test
    public void ISBN_shorterThan13Characters() {
        // Arrange
        // ISBNFinder sut = new ISBNFinder();

        // Act
        String shortISBN = "12345";
        //BookInfo actual = sut.lookup(shortISBN);
        boolean actual = isIt13(shortISBN);

        // Assert
        assertFalse(actual);
    }
    @Test
    public void ISBN_greaterThan13Characters() {
        // Arrange
        // ISBNFinder sut = new ISBNFinder();

        // Act
        String shortISBN = "123456789101112";
        //BookInfo actual = sut.lookup(shortISBN);
        boolean actual = isIt13(shortISBN);

        // Assert
        assertFalse(actual);
    }
    @Test
    public void ISBN_equalsTo13Characters() {
        // Arrange
        // ISBNFinder sut = new ISBNFinder();

        // Act
        String shortISBN = "9780593959312";
        //BookInfo actual = sut.lookup(shortISBN);
        boolean actual = isIt13(shortISBN);

        // Assert
        assertTrue(actual);
    }


    private boolean isIt13(String shortISBN) {
        if (shortISBN.length() == 13) {
            return true;
        } else {
            return false;
        }
    }

}
