package golang

import "slices"

func combinations(nums []int, k int) [][]int {
	var loop func([]int, int)

	var results [][]int

	loop = func(combination []int, start int) {
		if len(combination) == k {
			results = append(results, combination)
			return
		}

		requested := k - len(combination)
		available := func(i int) int {
			return len(nums) - i
		}
		for i := start; i < len(nums) && requested <= available(i); i++ {
			nextCombination := append(slices.Clone(combination), nums[i])
			loop(nextCombination, i+1)
		}
	}

	loop(nil, 0)
	return results
}
