package org.whsv26.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combinations {

    public static void main(String[] args) {
        assert(
            Combinator.of(4, 2)
                .combine()
                .equals(List.of(
                    List.of(1, 2),
                    List.of(1, 3),
                    List.of(1, 4),
                    List.of(2, 3),
                    List.of(2, 4),
                    List.of(3, 4)
                ))
        );

        assert(
            FullCombinator.of(3, 3)
                .combineAll()
                .equals(List.of(
                    List.of(1),
                    List.of(1, 2),
                    List.of(1, 2, 3),
                    List.of(1, 3),
                    List.of(2),
                    List.of(2, 3),
                    List.of(3)
                ))
        );
    }

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            return Combinator.of(n, k).combine();
        }
    }

    record Combinator(int to, int k, Stack<Integer> combination, List<List<Integer>> combinations) {

        public List<List<Integer>> combine() {
            loop(0);
            return combinations;
        }

        private void loop(int from) {
            if (combination.size() == k) {
                combinations.add(combination.stream().toList());
                return;
            }

            for (int i = from; i < to; i++) {
                var available = to - i;
                var requested = k - combination.size();
                if (requested <= available) {
                    combination.push(i + 1);
                    loop(i + 1);
                    combination.pop();
                }
            }
        }

        public static Combinator of(int n, int k) {
            return new Combinator(n, k, new Stack<>(), new ArrayList<>());
        }
    }

    record FullCombinator(int to, int k, Stack<Integer> combination, List<List<Integer>> combinations) {

        public List<List<Integer>> combineAll() {
            loop(0);
            return combinations;
        }

        private void loop(int from) {
            if (combination.size() == k) {
                return;
            }

            for (int i = from; i < to; i++) {
                combination.push(i + 1);
                combinations.add(combination.stream().toList());
                loop(i + 1);
                combination.pop();
            }
        }

        public static FullCombinator of(int n, int k) {
            return new FullCombinator(n, k, new Stack<>(), new ArrayList<>());
        }
    }
}