package com.codeWars.my;

/**
 * given two speeds v1 (A's speed, integer > 0) and v2 (B's speed, integer > 0) and a lead g (integer > 0) how long will it take B to catch A?
 * The result will be an array [hour, min, sec] which is the time needed in hours, minutes and seconds (round down to the nearest second) or
 * a string in some languages.
 * If v1 >= v2 then return nil, nothing, null, None or {-1, -1, -1} for C++, C, Go, Nim, Pascal, COBOL, Erlang, [-1, -1, -1] for Perl,[] for Kotlin or "-1 -1 -1".
 * <p>
 * Examples:
 * (form of the result depends on the language)
 * <p>
 * race(720, 850, 70) => [0, 32, 18] or "0 32 18"
 * race(80, 91, 37)   => [3, 21, 49] or "3 21 49"
 */

public class TortoiseRacing {

    public static int[] race(int v1, int v2, int g) {
        if (v1 >= v2) return null;
        int c = (int) ((double) g / (v2 - v1) * 3600);
        return new int[]{c / 3600, c / 60 % 60, c % 60};
    }
}
