package golang

func searchInsert(nums []int, target int) int {
	l, r := 0, len(nums)

	for l < r {
		mid := (r-l)/2 + l

		if target > nums[mid] {
			l = mid + 1
		} else if target < nums[mid] {
			r = mid
		} else {
			return mid
		}
	}

	return l
}

func searchInsertRecursive(nums []int, target int) int {
	return searchInsertRecursiveLoop(nums, target, 0, len(nums))
}

func searchInsertRecursiveLoop(nums []int, target, from, to int) (insertIdx int) {
	if to == from {
		return from
	}

	mid := (to-from)/2 + from

	if target > nums[mid] {
		return searchInsertRecursiveLoop(nums, target, mid+1, to)
	} else if target < nums[mid] {
		return searchInsertRecursiveLoop(nums, target, from, mid)
	} else {
		return mid
	}
}
