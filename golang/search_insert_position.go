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
	var loop func(nums []int, target, l, r int) int

	loop = func(nums []int, target, l, r int) (insertIdx int) {
		if r == l {
			return l
		}

		mid := (r-l)/2 + l

		if target > nums[mid] {
			return loop(nums, target, mid+1, r)
		} else if target < nums[mid] {
			return loop(nums, target, l, mid)
		} else {
			return mid
		}
	}

	return loop(nums, target, 0, len(nums))
}
