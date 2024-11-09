package golang_problems

func isPalindrome(x int) bool {
	if x < 0 {
		return false
	}

	var reversed, original = 0, x

	for x > 0 {
		reversed = reversed*10 + (x % 10)
		x /= 10
	}

	return reversed == original
}
