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

        if (ISBN.length() == 13) {
            return new ISBN13(ISBN).retrieve(this.isbnService);
        }

        String processedISBN = ISBN.replace(" ", "");

        if (processedISBN.length() < 10) {
            return new BookInfo("ISBN must be 10 characters in length");
        } else if (processedISBN.length() > 10) {
            return new BookInfo("ISBN must be 10 characters in length");
        } else {

            BookInfo bookInfo = new ISBN13(processedISBN).retrieve(isbnService);

            if (null == bookInfo) {
                return new BookInfo("Title not found");
            }

            return bookInfo;
        }
    }
}
