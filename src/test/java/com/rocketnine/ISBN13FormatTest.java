package com.rocketnine;

import dev.emergent.BookInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ISBN13FormatTest {

    @Test
    void ISBNFinderRejectsInputContainsInvalidCharacters() {

        ISBNFinder sut = new ISBNFinder();

        BookInfo bookInfo = sut.lookup("9A8-0-13-595705-9");
        assertEquals(new BookInfo("ISBN should only contain digits and hyphens/spaces").toString(), bookInfo.toString());

    }

    @ParameterizedTest(name = "{0}")
    @CsvSource({"9380135957053454359", "45645645", "35235678887"})
    void ISBNFinderRejectsInputDifferentThan10or13Digits(String isbn) {
        ISBNFinder sut = new ISBNFinder();

        BookInfo bookInfo = sut.lookup(isbn);
        assertEquals(new BookInfo("ISBN must be 10 or 13 characters in length").toString(), bookInfo.toString());
    }

    @Test
    void ISBNFindeIgnoresHyphens() {
        ISBNFinder sut = new ISBNFinder();

        BookInfo bookInfo = sut.lookup("938-0-13-595705-9");
        assertEquals(new BookInfo("Title not found").toString(), bookInfo.toString());
    }

    @Test
    void ISBNFindeIgnoresSpaces() {
        ISBNFinder sut = new ISBNFinder();

        BookInfo bookInfo = sut.lookup("938 0 13 595705 9");
        assertEquals(new BookInfo("Title not found").toString(), bookInfo.toString());
    }

    @Test
    void ISBNFinderRetrieveBookFromExistingIsbn13() {
        ISBNFinder sut = new ISBNFinder();

        BookInfo actual = sut.lookup("978 0596-80948 5");
        BookInfo expected = new BookInfo(
                "97 Things Every Programmer Should Know",
                "Kevlin Henney",
                "0596809484",
                "9780596809485"
        );
        assertEquals(expected.toString(), actual.toString());
    }

}
