package com.codeWars.my;

/**
 * Given the string representations of two integers, return the string representation of the sum of those integers.
 * <p>
 * For example:
 * <p>
 * sumStrings('1','2') // => '3'
 * A string representation of an integer will contain no characters besides the ten numerals "0" to "9".
 * <p>
 * I have removed the use of BigInteger and BigDecimal in java
 * <p>
 * Python: your solution need to work with huge numbers (about a milion digits), converting to int will not work.
 */

public class SumStringsAsNumbers {
    public static void main(String[] args) {
        System.out.println("3000".equals(sumStrings("999", "2001")));
    }

    public static String sumStrings(String a, String b) {
        int tempA;
        int tempB;
        int tempC;
        int up = 0;
        StringBuilder sbLong, sbShot;
        StringBuilder sbResult = new StringBuilder();
        if (a.length() >= b.length()) {
            sbLong = new StringBuilder(a);
            sbShot = new StringBuilder(b);
        } else {
            sbLong = new StringBuilder(b);
            sbShot = new StringBuilder(a);
        }
        int lMax = sbLong.length();
        for (int i = 0; i < lMax; i++) {
            tempA = Integer.parseInt(sbLong.substring(sbLong.length() - 1));
            if (sbShot.length() > 0)
                tempB = Integer.parseInt(sbShot.substring(sbShot.length() - 1));
            else tempB = 0;
            tempC = tempA + tempB + up;
            sbResult.append(tempC % 10);
            up = tempC / 10;
            sbLong.deleteCharAt(sbLong.length() - 1);
            if (sbShot.length() > 0)
                sbShot.deleteCharAt(sbShot.length() - 1);
        }
        sbResult.append(up > 0 ? up : "");
        while (sbResult.substring(sbResult.length() - 1).equals("0"))
            sbResult.deleteCharAt(sbResult.length() - 1);
        return sbResult.reverse().toString();
    }
}
