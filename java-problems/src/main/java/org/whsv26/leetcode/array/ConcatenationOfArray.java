package org.whsv26.leetcode.array;

import java.util.Arrays;

public class ConcatenationOfArray {
    public static void main(String[] args) {
        var solutions = new Solution();
        assert (Arrays.equals(
            new int[]{1, 2, 1, 1, 2, 1},
            solutions.getConcatenation(new int[]{1, 2, 1})
        ));
    }

    static class Solution {
        public int[] getConcatenation(int[] nums) {
            var res = new int[nums.length * 2];
            System.arraycopy(nums, 0, res, 0, nums.length);
            System.arraycopy(nums, 0, res, nums.length, nums.length);
            return res;
        }
    }

    static class SlowSolution {
        public int[] getConcatenation(int[] nums) {
            var res = new int[nums.length * 2];

            for (int i = 0; i < nums.length * 2; i++) {
                res[i] = nums[i % nums.length];
            }

            return res;
        }
    }
}