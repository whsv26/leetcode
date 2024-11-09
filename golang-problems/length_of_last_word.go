package golang_problems

func lengthOfLastWord(s string) int {
	size := 0

	for i := 0; i < len(s); i++ {
		if s[i] != ' ' {
			size++
		}

		if i+1 < len(s) && s[i+1] != ' ' && s[i] == ' ' {
			size = 0
		}
	}

	return size
}
