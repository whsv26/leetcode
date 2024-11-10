package org.whsv26.leetcode.string;

public class FinalValueOfVariableAfterPerformingOperations {
    public static void main(String[] args) {
        var solutions = new Solution();
        assert (1 == solutions.finalValueAfterOperations(new String[]{"--X", "X++", "++X"}));
    }

    static class Solution {
        public int finalValueAfterOperations(String[] operations) {
            var res = 0;
            for (var operation : operations) {
                switch (operation) {
                    case "--X", "X--" -> res--;
                    case "++X", "X++" -> res++;
                }
            }
            return res;
        }
    }
}