package com.rocketnine;

import dev.emergent.BookInfo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


class ISBN10Test {

    @Test
    void Valid_ISBN_BookFound() {
        // Arrange
        ISBNFinder sut = new ISBNFinder();

        // Act
        String ISBN = "0321146530";
        BookInfo actual = sut.lookup(ISBN);

        // Assert
        BookInfo expected = new BookInfo("Test Driven Development by Example", "Kent Beck", "0321146530", "9780321146533");
        assertEquals(expected.toString(), actual.toString());
    }


    @Test
    void Invalid_ISBN_shorterThan10Characters_ReturnsInvalidBookInfo() {
        ISBNFinder sut = new ISBNFinder();

        String shortISBN = "12345";
        BookInfo actual = sut.lookup(shortISBN);

        assertEquals("ISBN must be 10 characters in length", actual.title);
    }

    @Test
    void Invalid_ISBN_longerThan10Characters_ReturnsInvalidBookInfo() {
        ISBNFinder sut = new ISBNFinder();

        String longISBN = "1234567890BCDEF";
        BookInfo actual = sut.lookup(longISBN);

        assertEquals("ISBN must be 10 characters in length", actual.title);
    }

    @Test
    void Invalid_ISBN_BookNotFound() {
        ISBNFinder sut = new ISBNFinder();

        String unknownISBN = "0553562614";
        BookInfo actual = sut.lookup(unknownISBN);

        assertEquals("Title not found", actual.title);
    }

    @Test
//    @Disabled("Expect CI build to pass when this test is not run")
    void FailingTest_BreaksTheBuild() {
        fail("Azure build should fail when running this test. Delete this test to get a Green build.");
    }
}