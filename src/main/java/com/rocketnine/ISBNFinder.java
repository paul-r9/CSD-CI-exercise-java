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

        // validate ISBN 
        if (!isValidISBN13(ISBN) && ISBN.length() == 13) {
            return new BookInfo("Invalid ISBN-13 checksum");
        } 

        if (isValidISBN13(ISBN) && ISBN.length() == 13) {
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

    public boolean isValidISBN13(String ISBN) {
        if (ISBN.length() != 13) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(ISBN.charAt(i));
            sum += (i % 2 == 0) ? digit : digit * 3; 
        }

        int checksum = (10 - (sum % 10)) % 10;
        int providedChecksum = Character.getNumericValue(ISBN.charAt(12));

        return checksum == providedChecksum;
    }
}