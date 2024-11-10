package org.whsv26.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {

    public static void main(String[] args) {
        var solutions = new Solution();
        var actual = solutions.combine(4, 2);
        var expected = List.of(
            List.of(1, 2),
            List.of(1, 3),
            List.of(1, 4),
            List.of(2, 3),
            List.of(2, 4),
            List.of(3, 4)
        );
        assert expected.equals(actual);
    }

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            loop(new Stack<>(), 0, n, k, res);
            return res;
        }

        private void loop(Stack<Integer> stack, int from, int to, int k, List<List<Integer>> res) {
            if (stack.size() == k) {
                res.add(stack.stream().toList());
                return;
            }

            for (int i = from; i < to; i++) {
                var available = to - i;
                var requested = k - stack.size();
                if (requested <= available) {
                    stack.push(i + 1);
                    loop(stack, i + 1, to, k, res);
                    stack.pop();
                }
            }
        }
    }
}