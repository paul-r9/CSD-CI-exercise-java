package com.rocketnine;

import dev.emergent.BookInfo;
import dev.emergent.BookInfoProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ISBN13ChecksumTest {
//    @Test
//    public void FailingTest_BreaksTheBuild() {
//        fail("Azure build regarding ISBN13Checksum is broken. Delete this test to get a Green build.");
//    }

    @Test
    public void ISBN_exact_13() {
        // Arrange
        ISBNFinder sut = new ISBNFinder();

        // Act
        String shortISBN = "9780596809485";
        BookInfo actual = sut.lookup(shortISBN);

        // Assert
        assertEquals(13, actual.isbn13().length());
    }

    @Test
    public void ISBN_checksum_13() {
        // Arrange
        ISBNFinder sut = new ISBNFinder();

        // Act
        String shortISBN = "9780596809485";
        BookInfo actual = sut.lookup(shortISBN);

        // Assert
        assertAll("Should return:",
                () -> assertEquals(5, ISBN13ChecksumCalculator.calculateChecksumConcise(actual.isbn13())),
                () -> assertEquals(5, ISBN13ChecksumCalculator.calculateChecksumWordy(actual.isbn13())));

    }
}
