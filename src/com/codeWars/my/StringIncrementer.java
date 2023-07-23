package com.codeWars.my;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Your job is to write a function which increments a string, to create a new string.
 * <p>
 * If the string already ends with a number, the number should be incremented by 1.
 * If the string does not end with a number. the number 1 should be appended to the new string.
 * Examples:
 * <p>
 * foo -> foo1
 * foobar23 -> foobar24
 * foo0042 -> foo0043
 * foo9 -> foo10
 * foo099 -> foo100
 * <p>
 * Attention: If the number has leading zeros the amount of digits should be considered.
 */


public class StringIncrementer {

    public static String incrementString(String str) {

        if (str == null || str.equals("")) return "1";

        List<Integer> integerList = new StringBuilder(str)
                .reverse()
                .chars()
                .takeWhile(Character::isDigit)
                .limit(19)
                .boxed()
                .collect(Collectors.toList());

        if (integerList.size() == 0) return str + "1";

        StringBuilder oldNumber = new StringBuilder(integerList
                .stream()
                .mapToInt(x -> x)
                .mapToObj(x -> String.valueOf((char) x))
                .collect(Collectors.joining()))
                .reverse();

        StringBuilder newNumber = new StringBuilder(String.valueOf(Long.parseLong(String.valueOf(oldNumber)) + 1));

        while (oldNumber.length() > newNumber.length()) newNumber.insert(0, "0");

        return str.substring(0, str.length() - oldNumber.length()) + newNumber;
    }
}
