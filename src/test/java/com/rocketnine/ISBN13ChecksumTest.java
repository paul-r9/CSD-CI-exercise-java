package com.rocketnine;

import dev.emergent.BookInfo;
import dev.emergent.BookInfoProvider;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


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

//    @Test
//    public void ISBN_shorterThan10Characters_ReturnsInvalidBookInfo() {
//        // Arrange
//        ISBNFinder sut = new ISBNFinder();
//
//        // Act
//        String shortISBN = "12345";
//        BookInfo actual = sut.lookup(shortISBN);
//
//        // Assert
//        assertEquals("ISBN must be 10 characters in length", actual.title);
//    }
}