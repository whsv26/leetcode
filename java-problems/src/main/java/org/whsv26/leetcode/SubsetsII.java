package org.whsv26.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SubsetsII {

    public static void main(String[] args) {
        var solutions = new Solution();
        var actual = solutions.subsetsWithDup(new int[]{1,2,2});
        assert (actual.equals(
            List.of(
                List.of(),
                List.of(1),
                List.of(1,2),
                List.of(1,2,2),
                List.of(2),
                List.of(2, 2)
            )
        ));
    }

    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            var result = new ArrayList<List<Integer>>();
            result.add(Collections.emptyList());
            backtrack(0, nums, result, new Stack<>());
            return result;
        }

        void backtrack(int start, int[] nums, List<List<Integer>> subsets, Stack<Integer> subset) {
            if (subset.size() == nums.length) {
                return;
            }

            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                subset.push(nums[i]);
                subsets.add(subset.stream().toList());
                backtrack(i + 1, nums, subsets, subset);
                subset.pop();
            }
        }
    }
}