package golang

import "math"

func isHappy(n int) bool {
	square := func(n int) (sum int) {
		for ; n != 0; n /= 10 {
			digit := float64(n % 10)
			sum += int(math.Pow(digit, 2.0))
		}
		return sum
	}

	slow, fast := square(n), square(square(n))

	for slow != fast {
		slow = square(slow)
		fast = square(square(fast))
	}

	return slow == 1
}
