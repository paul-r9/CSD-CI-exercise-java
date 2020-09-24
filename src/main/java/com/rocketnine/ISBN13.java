package com.rocketnine;


import dev.emergent.BookInfo;
import dev.emergent.BookInfoProvider;

public class ISBN13 {
    private String isbn;

    public ISBN13(String ISBN) {
        isbn = ISBN;
    }

    public BookInfo retrieve(BookInfoProvider isbnService) {


        if (isbn.length() > 13) {
            return new BookInfo("ISBN must be 13 characters in length");
        }

        boolean isValidCheckSum = validateCheckSum(isbn);

        if (isValidCheckSum) {
            return isbnService.retrieve(isbn);
        }
        return new BookInfo("ISBN is NOT Valid CheckSum");
    }

    private boolean validateCheckSum(String isbn) {
        return true;
    }
}
