package com.rocketnine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ISBN13ChecksumTest {

    @Test
    public void ISBN_checkSum13_DoesNotThrow() {
        ISBNFinder sut = new ISBNFinder();
        Assertions.assertTrue(sut.checkSum13());
    }
}
