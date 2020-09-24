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

        String processedISBN = ISBN.replace(" ", "").replace("-", "");

        if (processedISBN.length() == 13) {
            return new ISBN13(processedISBN).retrieve(this.isbnService);
        }

        if (processedISBN.length() < 10) {
            return new BookInfo("ISBN must be 10 characters in length");
        } else if (processedISBN.length() > 10) {
            return new BookInfo("ISBN must be 10 characters in length");
        } else {

            if (!isValidChecksum(processedISBN)) {
                return new BookInfo("Invalid ISBN");
            }

            BookInfo bookInfo = new ISBN13(processedISBN).retrieve(isbnService);

            if (null == bookInfo) {
                return new BookInfo("Title not found");
            }

            return bookInfo;
        }
    }

    private boolean isValidChecksum(String processedISBN) {

        //return false when not valid
        //return true when valid

        int sum = 0;

        for (int i = 0; i < processedISBN.length() - 1; i++) {
            int c = Character.getNumericValue(processedISBN.charAt(i));
            sum += (i + 1) * c;
        }

        int modulo = sum % 11;

        if (modulo == 10) {
            // NEED A TEST FOR THIS CASE
            return 'X' == processedISBN.charAt(9);
        }

        int lastDigit = Character.getNumericValue(processedISBN.charAt(9));
        return lastDigit == modulo;
    }
}
