package com.rocketnine;


import dev.emergent.BookInfo;
import dev.emergent.BookInfoProvider;

public class ISBN13 {
    private String isbn;

    public ISBN13(String ISBN) {
        isbn = ISBN;
    }

    public BookInfo retrieve(BookInfoProvider isbnService) {
        return isbnService.retrieve(isbn);
    }
}
