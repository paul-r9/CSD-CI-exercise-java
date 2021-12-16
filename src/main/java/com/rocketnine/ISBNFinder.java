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

    public boolean checkSum13(String ISBN)
    {
        final char [] numbers = ISBN.toCharArray();




        // 1st: x1  , 2nd: x3
        //“9780471486480”
        for(int i = 0; i < numbers.length;++i){
//            if(indexIsEven()){
//
//            }else{
//
//            }
        }



       int i =0;
      try {
          i = Integer.parseInt(ISBN);
      }catch (NumberFormatException e) {
          return false;
      }
      return true;
    }

    public BookInfo lookup(String ISBN) {
        ISBN = sanitize(ISBN);

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

    public String sanitize(String ISBN) {
        return ISBN.replaceAll(" ", "").replaceAll("-", "");
    }

}