package com.rocketnine;

import dev.emergent.BookInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ISBN13FormatTest {

    @Test
    void ISBN13FinderRejectsInputContainsInvalidCharacters() {

        ISBNFinder sut = new ISBNFinder();

        BookInfo bookInfo = sut.lookup("9A8-0-13-595705-9");
        assertEquals(new BookInfo("ISBN should only contain digits and hyphens/spaces.").toString(), bookInfo.toString());

    }

}
