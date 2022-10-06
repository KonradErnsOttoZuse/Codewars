package com.codeWars.my;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Greed is a die game played with five six-sided dice. Your mission, should you choose to accept it, is to score
 * a throw according to these rules. You will always be given an array with five six-sided dice values.
 * <p>
 * Three 1's => 1000 points
 * Three 6's =>  600 points
 * Three 5's =>  500 points
 * Three 4's =>  400 points
 * Three 3's =>  300 points
 * Three 2's =>  200 points
 * One   1   =>  100 points
 * One   5   =>   50 point
 * A single die can only be counted once in each roll. For example, a given "5" can only count as part of a triplet
 * (contributing to the 500 points) or as a single 50 points, but not both in the same roll.
 * <p>
 * Example scoring
 * <p>
 * Throw       Score
 * ---------   ------------------
 * 5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
 * 1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
 * 2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)
 */
public class GreedIsGood {

    public static int greedy(int[] dice) {
        int[][] rules = new int[][]{
                {100, 200, 1000, 1100, 1200},
                {0, 0, 200, 200, 200},
                {0, 0, 300, 300, 300},
                {0, 0, 400, 400, 400},
                {50, 100, 500, 550, 600},
                {0, 0, 600, 600, 600}
        };

        return Arrays.stream(dice)
                .boxed()
                .collect(Collectors.groupingBy(x -> x,Collectors.counting()))
                .entrySet()
                .stream()
                .map(x -> rules[x.getKey() - 1][Math.toIntExact(x.getValue()) - 1])
                .mapToInt(x -> x)
                .sum();

    }

    public static int greedy2(int[] dice) {
        int[] n = new int[7];
        for (int d : dice) n[d]++;
        return n[1]/3*1000 + n[1]%3*100 + n[2]/3*200 + n[3]/3*300 + n[4]/3*400 + n[5]/3*500 + n[5]%3*50 + n[6]/3*600;
    }
}