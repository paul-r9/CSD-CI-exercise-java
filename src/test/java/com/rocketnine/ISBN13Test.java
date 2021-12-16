package com.rocketnine;

import dev.emergent.BookInfo;
import dev.emergent.BookInfoProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ISBN13Test {

    @Test
    public void ISBN_acceptsDashesAndSpaces() {
        // Arrange
        ISBNFinder sut = new ISBNFinder();

        // Act

        String isbn13 = "- 9-7-8-0-5 9 6 8 0- 9 -4 8-5 -";
        BookInfo actual = sut.lookup(isbn13);

        // Assert
        assertEquals("9780596809485", actual.isbn13());
    }
}
