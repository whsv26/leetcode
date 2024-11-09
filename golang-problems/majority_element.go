package golang_problems

func majorityElement(nums []int) int {
	counter := 0
	major := 0

	for _, num := range nums {
		if counter == 0 {
			major = num
			counter++
		} else if major == num {
			counter++
		} else {
			counter--
		}
	}

	return major
}
