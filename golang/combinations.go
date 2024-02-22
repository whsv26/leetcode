package golang

import "slices"

func combinations(nums []int, k int) [][]int {
	var loop func(int)

	var results [][]int
	var stack []int

	loop = func(start int) {
		if len(stack) == k {
			results = append(results, slices.Clone(stack))
			return
		}

		requested := k - len(stack)
		available := func(i int) int {
			return len(nums) - i
		}

		for i := start; i < len(nums) && requested <= available(i); i++ {
			stack = append(stack, nums[i])
			loop(i + 1)
			stack = stack[:len(stack)-1]
		}
	}

	loop(0)
	return results
}
