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
        Assertions.assertTrue(sut.checkSum13("123455"));
    }

    @Test
    public void ISBN_checkSum13_DoesThrow() {
        ISBNFinder sut = new ISBNFinder();
        Assertions.assertFalse(sut.checkSum13("123455aaaa"));
    }


}
