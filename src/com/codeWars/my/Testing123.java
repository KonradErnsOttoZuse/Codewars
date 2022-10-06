package com.codeWars.my;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Your team is writing a fancy new text editor and you've been tasked with implementing the line numbering.
 * <p>
 * Write a function which takes a list of strings and returns each line prepended by the correct number.
 * <p>
 * The numbering starts at 1. The format is n: string. Notice the colon and space in between.
 * <p>
 * Examples: (Input --> Output)
 * [] --> []
 * ["a", "b", "c"] --> ["1: a", "2: b", "3: c"]
 */
public class Testing123 {
    public static List<String> number(List<String> lines) {
        final int[] y = {1};
        return lines
                .stream()
                .map(x -> y[0]++ + ": " + x)
                .collect(Collectors.toList());
    }
}
