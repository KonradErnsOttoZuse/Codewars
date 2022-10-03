package com.codeWars.my;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * Count the number of Duplicates
 * Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric
 * digits that occur more than once in the input string. The input string can be assumed to contain
 * only alphabets (both uppercase and lowercase) and numeric digits.
 * <p>
 * Example
 * "abcde" -> 0 # no characters repeats more than once
 * "aabbcde" -> 2 # 'a' and 'b'
 * "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
 * "indivisibility" -> 1 # 'i' occurs six times
 * "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
 * "aA11" -> 2 # 'a' and '1'
 * "ABBA" -> 2 # 'A' and 'B' each occur twice
 * <p>
 * STRINGSFUNDAMENTALS
 */

public class CountingDuplicates {

    public static int duplicateCount(String text) {
        Map<String, Integer> map = new HashMap<>();
        for (char ch : text.toLowerCase().toCharArray()) {
            int value = 1;
            String key = String.valueOf(ch);
            if (map.containsKey(key)) {
                value = map.get(key) + 1;
            }
            map.put(key, value);
        }
        return (int) map
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .count();
    }

    public static int duplicateCount2(String text) {
        return
                (int) text.toLowerCase()
                        .codePoints()
                        .boxed()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(x -> x.getValue() > 1)
                        .count();

    }

    public static int duplicateCount3(String text) {
        return
                (int) text.toLowerCase()
                        .chars()
                        .boxed()
                        .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                        .values()
                        .stream()
                        .filter(x -> x > 1)
                        .count();

    }


    public static int duplicateCount4(String text) {
        List<String> list = Arrays.asList(text.toLowerCase().split(""));
        return (int) list.stream().filter(s -> Collections.frequency(list, s) > 1).distinct().count();
    }
}
