package com.rocketnine;

import dev.emergent.BookInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ISBN13ChecksumTest {

    @Test
    public void ISBN_checkSum13_DoesNotThrow() {
        ISBNFinder sut = new ISBNFinder();
        Assertions.assertTrue(sut.checkSum13());
    }

    @Test
    public void ISBN13_shorterThan10Characters_ReturnsInvalidBookInfo() {
        // Arrange
        ISBNFinder sut = new ISBNFinder();

        // Act
        String shortISBN = "1234544444444444";
        BookInfo actual = sut.lookup(shortISBN);

        // Assert
        assertEquals("ISBN must be 10 characters in length", actual.title);
    }

}
