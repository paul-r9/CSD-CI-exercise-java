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

    public String CalculateChecksum(String ISBN){
        int checksum = 0;
        // define int list for alternating digits
        char [] charArray = ISBN.toCharArray();

        for (int i = 0; i < (charArray.length - 1); i++) {
            if(i%2 == 0){
                checksum += Character.getNumericValue(charArray[i]); // multiply by 1
            }
            else{
                checksum += Character.getNumericValue(charArray[i]) * 3;
            }
        }

        checksum = 10 - (checksum % 10);

        return String.valueOf(checksum);

        // loop over ISBN
            // convert digit from string to int
            // do calculation with ints
            // append to result as character to checksum
            // flip alternating digits

//        return ISBN.substring(ISBN.length()-1, ISBN.length());
    }
}