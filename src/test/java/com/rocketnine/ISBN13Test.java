package com.rocketnine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ISBN13Test {
    @Test
    public void ISBN_validISBN13_CalculateChecksum() {

        String ISBN = "9781328948854";
        String checksumResult;

        ISBNFinder sut = new ISBNFinder();

        checksumResult = sut.CalculateChecksum(ISBN);

        assertEquals("4", checksumResult);
    }
}
