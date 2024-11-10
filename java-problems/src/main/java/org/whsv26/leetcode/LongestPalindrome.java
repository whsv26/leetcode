package org.whsv26.leetcode;

import java.util.HashMap;

public class LongestPalindrome {

    public static void main(String[] args) {
        var solutions = new Solution();
        assert (11 == solutions.longestPalindrome("aaabbbccddee"));
        assert (11 == solutions.longestPalindrome("aaabbccddee"));
        assert (7 == solutions.longestPalindrome("xqaaaddee"));
        assert (1 == solutions.longestPalindrome("abcde"));
    }

    static class Solution {
        public int longestPalindrome(String s) {
            var occurByChar = new HashMap<Integer, Integer>();
            s.chars().forEach(c -> occurByChar.merge(c, 1, Integer::sum));

            var occurSum = occurByChar.values().stream()
                .mapToInt(n -> n % 2 == 0 ? n : n - 1)
                .sum();

            return occurSum < s.length() ? occurSum + 1 : occurSum;
        }
    }
}