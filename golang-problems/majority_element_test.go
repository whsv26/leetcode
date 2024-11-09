package golang_problems

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
		{[]int{6, 6, 6, 7, 7}, 6},
		{[]int{8, 9, 8, 9, 8}, 8},
		{[]int{10, 9, 9, 9, 10}, 9},
	}

	for i, test := range tests {
		t.Run(fmt.Sprintf("Example %v", i+1), func(t *testing.T) {
			results := []int{
				majorityElement(test.Nums),
			}

			for _, actual := range results {
				if actual != test.Expected {
					t.Errorf("Expected %v, got %v", test.Expected, actual)
				}
			}
		})
	}
}
