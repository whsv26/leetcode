package org.whsv26.leetcode;

public class ScoreOfAString {

    public static void main(String[] args) {
        var solutions = new Solution();
        assert (13 == solutions.scoreOfString("hello"));
    }

    static class Solution {
        public int scoreOfString(String s) {
            var sum = 0;

            for (int i = 1; i < s.length(); i++) {
                sum += Math.abs(s.charAt(i - 1) - s.charAt(i));
            }

            return sum;
        }
    }
}