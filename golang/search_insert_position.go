package golang

func searchInsert(nums []int, target int) int {
	return searchInsertLoop(nums, target, 0, len(nums))
}

func searchInsertLoop(nums []int, target, from, to int) (insertIdx int) {
	if to == from {
		return from
	}

	mid := (to-from)/2 + from

	if target > nums[mid] {
		return searchInsertLoop(nums, target, mid+1, to)
	} else if target < nums[mid] {
		return searchInsertLoop(nums, target, from, mid)
	} else {
		return mid
	}
}
