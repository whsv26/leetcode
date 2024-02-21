package golang

import "slices"

func combinations(nums []int, k int) [][]int {
	var loop func([]int, int) [][]int

	loop = func(combination []int, start int) [][]int {
		if len(combination) == k {
			return [][]int{combination}
		}

		var res [][]int
		requested := k - len(combination)
		available := func(i int) int {
			return len(nums) - i
		}
		for i := start; i < len(nums) && available(i) >= requested; i++ {
			nextCombination := append(slices.Clone(combination), nums[i])
			res = append(res, loop(nextCombination, i+1)...)
		}

		return res
	}

	return loop(nil, 0)
}
