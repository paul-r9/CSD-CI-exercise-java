package com.rocketnine;

import dev.emergent.BookInfo;
import dev.emergent.BookInfoProvider;
import dev.emergent.ISBNService;

public class ISBNFinder {

    private BookInfoProvider isbnService = null;

    public ISBNFinder() {
        this(ISBNService.getInstance());
    }

    public ISBNFinder(BookInfoProvider bookInfoProvider) {
        isbnService = bookInfoProvider;
    }

    public BookInfo lookup(String ISBN) {
        ISBN = ISBN.replaceAll(" ", "");
        ISBN = ISBN.replaceAll("-", "");

        if (ISBN.length() == 13) {
            return isbnService.retrieve(ISBN);
        }

        if (ISBN.length() < 10) {
            return new BookInfo("ISBN must be 10 characters in length");
        } else if (ISBN.length() > 10) {
            return new BookInfo("ISBN must be 10 characters in length");
        } else {

            BookInfo bookInfo = isbnService.retrieve(ISBN);

            if (null == bookInfo) {
                return new BookInfo("Title not found");
            }

            return bookInfo;
        }
    }
}
