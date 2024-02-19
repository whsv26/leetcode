package golang

import (
	"fmt"
	"testing"
)

func Test_majorityElement(t *testing.T) {
	tests := []struct {
		Nums     []int
		Expected int
	}{
		{[]int{2, 2, 1, 1, 1, 2, 2}, 2},
		{[]int{3, 2, 3}, 3},
		{[]int{3, 3, 4}, 3},
	}

	for i, test := range tests {
		t.Run(fmt.Sprintf("Example %v", i+1), func(t *testing.T) {
			actual := majorityElement(test.Nums)

			if actual != test.Expected {
				t.Errorf("Expected %v, got %v", test.Expected, actual)
			}
		})
	}
}
