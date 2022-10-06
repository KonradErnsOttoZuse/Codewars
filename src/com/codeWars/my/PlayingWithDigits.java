package com.codeWars.my;

import java.util.stream.IntStream;

/**
 * Some numbers have funny properties. For example:
 * <p>
 * 89 --> 8¹ + 9² = 89 * 1
 * 695 --> 6² + 9³ + 5⁴= 1390 = 695 * 2
 * 46288 --> 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
 * <p>
 * Given a positive integer n written as abcd... (a, b, c, d... being digits) and a positive integer p
 * we want to find a positive integer k, if it exists, such that the sum of the digits of n taken to the successive powers of p is equal to k * n.
 * <p>
 * In other words:
 * Is there an integer k such as : (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) + ...) = n * k
 * If it is the case we will return k, if not return -1.
 * <p>
 * Note: n and p will always be given as strictly positive integers.
 */
public class PlayingWithDigits {

    public static void main(String[] args) {
        System.out.println(digPow3(46288, 3));
    }

    public static long digPow(int n, int p) {
        double sumOfPow = 0;
        int m = Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString());
        while (m > 0) {
            sumOfPow += Math.pow(m % 10, p++);
            m /= 10;
        }
        if (sumOfPow / n - Math.round(sumOfPow / n) == 0) return (long) (sumOfPow / n);
        return -1;
    }

    public static long digPow2(int n, int p) {
        int[] digits = String.valueOf(n)
                .chars()
                .map(Character::getNumericValue).toArray();
        int sum = IntStream.range(0, digits.length).map(i -> (int) Math.pow(digits[i], i + p)).sum();
        return sum % n == 0 ? sum / n : -1;
    }

    public static long digPow3(int n, int p) {
        final int[] pow = {p};
        int sum = String.valueOf(n)
                .chars()
                .map(Character::getNumericValue)
                .map(x -> (int) Math.pow(x, pow[0]++)).sum();
        return sum % n == 0 ? sum / n : -1;
    }

}
