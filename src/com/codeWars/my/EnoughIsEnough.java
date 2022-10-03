package com.codeWars.my;


import java.util.*;
import java.util.stream.IntStream;

/**
 * Given a list and a number, create a new list that contains each number of list at most N times, without reordering.
 * For example if the input number is 2, and the input list is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2],
 * drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times, and then take 3,
 * which leads to [1,2,3,1,2,3].
 * With list [20,37,20,21] and number 1, the result would be [20,37,21].
 */

public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        Map<Integer, Integer> map = new HashMap<>();

        return Arrays.stream(elements)
                .filter(x -> {
                    int value = map.containsKey(x) ? map.get(x) + 1 : 1;
                    map.put(x, value);
                    return value <= maxOccurrences;
                })
                .toArray();
    }

    public static int[] deleteNth2(int[] elements, int maxOccurrences) {

        Map<Integer, Integer> map = new HashMap<>();

        return IntStream.of(elements)
                .filter(x ->
                        map.merge(x, 1, Integer::sum) <= maxOccurrences)
                .toArray();
    }
}
