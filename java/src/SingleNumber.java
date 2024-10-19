import java.util.Arrays;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
public class SingleNumber {

    public static void main(String[] args) {
        assert 0 == new Solution().singleNumber(new int[]{1, 1, 2, 2});
        assert 3 == new Solution().singleNumber(new int[]{1, 1, 2, 2, 3});
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (x, y) -> x ^ y);
    }
}
