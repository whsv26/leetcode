package golang_problems

import "math"

func isPowerOfTwo(n int) bool {
	if n == 0 {
		return false
	}
	log := math.Floor(math.Log2(float64(n)))
	return int(math.Pow(2, log)) == n
}
