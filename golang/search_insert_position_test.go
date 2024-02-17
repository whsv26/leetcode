package golang

import (
	"fmt"
	"testing"
)

func Test_searchInsert(t *testing.T) {

	tests := []struct {
		Nums     []int
		Target   int
		Expected int
	}{
		{[]int{1, 3, 5, 6}, 5, 2},
		{[]int{1, 3, 5, 6}, 2, 1},
		{[]int{1, 3, 5, 6}, 7, 4},
	}

	for i, test := range tests {
		t.Run(fmt.Sprintf("Example %v", i+1), func(t *testing.T) {
			actual := searchInsert(test.Nums, test.Target)
			if actual != test.Expected {
				t.Errorf("Expected %v, got %v", test.Expected, actual)
			}
		})
	}
}
