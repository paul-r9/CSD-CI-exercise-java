package com.rocketnine;

import dev.emergent.BookInfo;
import dev.emergent.BookInfoProvider;
import dev.emergent.ISBNService;

// Sarah

public class ISBNFinder {

    private BookInfoProvider isbnService = null;

    public ISBNFinder() {
        this(ISBNService.getInstance());
    }

    public ISBNFinder(BookInfoProvider bookInfoProvider) {
        isbnService = bookInfoProvider;
    }

    public BookInfo lookup(String isbn) {
        isbn.replace("-", "");
//        isbn.replace(" ", "");
        if (!isbn.matches("^[0-9]+$")) {
            return new BookInfo("ISBN should only contain digits and hyphens/spaces.");
        }

        if (isbn.length() < 10) {
            return new BookInfo("ISBN must be 10 characters in length");
        } else if (isbn.length() > 10) {
            return new BookInfo("ISBN must be 10 characters in length");
        } else {

            BookInfo bookInfo = isbnService.retrieve(isbn);

            if (null == bookInfo) {
                return new BookInfo("Title not found");
            }

            return bookInfo;
        }
    }
}