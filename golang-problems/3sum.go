package golang_problems

import (
	"slices"
)

func threeSum(nums []int) [][]int {
	var res [][]int
	slices.Sort(nums)

	for i := range nums {
		if i != 0 && nums[i] == nums[i-1] {
			continue // skip duplicates
		}
		j, k := i+1, len(nums)-1
		for j < k {
			if sum := nums[i] + nums[j] + nums[k]; sum < 0 {
				j++
			} else if sum > 0 {
				k--
			} else {
				res = append(res, []int{nums[i], nums[j], nums[k]})
				j++
				for j < k && nums[j] == nums[j-1] {
					j++ // skip duplicates
				}
			}
		}
	}

	return res
}
