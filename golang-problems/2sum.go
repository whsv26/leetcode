package golang_problems

func twoSum(nums []int, target int) []int {
	dict := make(map[int]int)

	for i, num := range nums {
		if j, ok := dict[num]; ok {
			return []int{j, i}
		}
		dict[target-num] = i
	}

	return nil
}
