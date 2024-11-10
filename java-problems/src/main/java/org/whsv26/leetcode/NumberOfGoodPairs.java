package org.whsv26.leetcode;

import java.util.HashMap;

// n! / r! * (n - r)!
// n * (n - 1) / 2
public class NumberOfGoodPairs {

    public static void main(String[] args) {
        var solutions = new Solution();
        assert (4 == solutions.numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    }

    static class Solution {
        public int numIdenticalPairs(int[] nums) {
            var occurrences = new HashMap<Integer, Integer>();

            for (int num : nums) {
                occurrences.merge(num, 1, Integer::sum);
            }

            return occurrences.values().stream()
                .mapToInt(n -> n * (n - 1) / 2)
                .sum();
        }
    }
}