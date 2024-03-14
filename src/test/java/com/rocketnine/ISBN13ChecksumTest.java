package com.rocketnine;

import dev.emergent.BookInfo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


class ISBN13ChecksumTest {
    
    @Test
    void Valid_Checksum() {
        // Arrange
        ISBNFinder sut = new ISBNFinder();

        // Act
        String ISBN = "0321146530";
        BookInfo actual = sut.lookup(ISBN);

       Character lastDigit = actual.isbn10().charAt(9);
       int checksum = Character.getNumericValue(lastDigit);

        // Assert
        //assertEquals(0, actual.toString().substring(actual.toString().length()-1, actual.toString().length()));
        assertEquals(0, checksum);
    }

}