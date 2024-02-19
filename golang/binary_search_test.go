package golang

import (
	"fmt"
	"testing"
)

func Test_search(t *testing.T) {
	tests := []struct {
		Nums     []int
		Target   int
		Expected int
	}{
		{[]int{-1, 0, 3, 5, 9, 12}, 9, 4},
		{[]int{-1, 0, 3, 5, 9, 12}, 2, -1},
	}

	for i, test := range tests {
		t.Run(fmt.Sprintf("Example %v", i+1), func(t *testing.T) {
			results := []int{
				search(test.Nums, test.Target),
			}

			for _, actual := range results {
				if actual != test.Expected {
					t.Errorf("Expected %v, got %v", test.Expected, actual)
				}
			}
		})
	}
}
