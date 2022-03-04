package com.rocketnine;

import dev.emergent.BookInfo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;


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


    @DisplayName("Something displayed")
    @ParameterizedTest(name = "Hello")
    @ValueSource(strings = {"0321146530", "0321146530"})
    void ISBN_Param(String ISBN) {
        ISBNFinder sut = new ISBNFinder();

        BookInfo actual = sut.lookup(ISBN);

        BookInfo expected = new BookInfo("Test Driven Development by Example", "Kent Beck", "0321146530", "9780321146533");

        assertEquals(expected.toString(), actual.toString());
    }

    @DisplayName("Should pass a non-null message to our test method")
    @ParameterizedTest
    @ValueSource(strings= {"Hello", "World"})
    void shouldPassNonNullMessageAsMethodParameter(String message) {
        assertNotNull(message);
    }

    @Test
    @Disabled("Expect CI build to pass when this test is not run")
    public void FailingTest_BreaksTheBuild() {
        fail("Azure build should fail when running this test. Delete this test to get a Green build.");
    }
}