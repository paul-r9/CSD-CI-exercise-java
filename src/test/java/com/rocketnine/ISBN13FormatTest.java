package com.rocketnine;

import dev.emergent.BookInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ISBN13FormatTest {

    @Test
    void ISBNFinderRejectsInputContainsInvalidCharacters() {

        ISBNFinder sut = new ISBNFinder();

        BookInfo bookInfo = sut.lookup("9A8-0-13-595705-9");
        assertEquals(new BookInfo("ISBN should only contain digits and hyphens/spaces").toString(), bookInfo.toString());

    }

    @Test
    void ISBNFinderRejectsInputLongerThan13Digits() {
        ISBNFinder sut = new ISBNFinder();

        BookInfo bookInfo = sut.lookup("9380135957053454359");
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


}
