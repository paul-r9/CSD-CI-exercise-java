package com.rocketnine;

public class ISBN13ChecksumCalculator {
   public static int calculateChecksumWordy(String isbm13){
       int one = 1;
       int three = 3;
       int ten = 10;

       int firstDigit = Integer.parseInt(isbm13.charAt(0) + "");
       int secondDigit = Integer.parseInt(isbm13.charAt(1) + "");
       int thirdDigit = Integer.parseInt(isbm13.charAt(2) + "");
       int fourthDigit = Integer.parseInt(isbm13.charAt(3) + "");
       int fifthDigit = Integer.parseInt(isbm13.charAt(4) + "");
       int sixthDigit = Integer.parseInt(isbm13.charAt(5) + "");
       int seventhDigit = Integer.parseInt(isbm13.charAt(6) + "");
       int eighthDigit = Integer.parseInt(isbm13.charAt(7) + "");
       int ninthDigit = Integer.parseInt(isbm13.charAt(8) + "");
       int tenthDigit = Integer.parseInt(isbm13.charAt(9) + "");
       int eleventhDigit = Integer.parseInt(isbm13.charAt(10) + "");
       int twelfthDigit = Integer.parseInt(isbm13.charAt(11) + "");

       int total = firstDigit * one +
               secondDigit * three +
               thirdDigit * one +
               fourthDigit * three +
               fifthDigit * one +
               sixthDigit * three +
               seventhDigit * one +
               eighthDigit * three +
               ninthDigit * one +
               tenthDigit * three +
               eleventhDigit * one +
               twelfthDigit * three;

       int lastDigit = ten - total % ten;

       return lastDigit;
   }

    public static int calculateChecksumConcise(String isbm13){
        int one = 1;
        int three = 3;
        int ten = 10;

        int total = 0;
        for (int i = 0; i < isbm13.length() - 1; i++) {
            int digit = Integer.parseInt(isbm13.charAt(i) + "");
            if (i % 2 == 0) {
                total += digit * one;
            } else {
                total += digit * three;
            }
        }

        int lastDigit = ten - total % ten;
        return lastDigit;
    }
}
