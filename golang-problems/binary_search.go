package golang_problems

func search(nums []int, target int) int {
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

	return -1
}
