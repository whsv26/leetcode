package golang_problems

import (
	"fmt"
	"reflect"
	"testing"
)

func Test_threeSum(t *testing.T) {
	tests := []struct {
		Nums     []int
		Expected [][]int
	}{
		{[]int{-1, 0, 1, 2, -1, -4}, [][]int{{-1, -1, 2}, {-1, 0, 1}}},
		{[]int{0, 1, 1}, nil},
		{[]int{0, 0, 0}, [][]int{{0, 0, 0}}},
	}

	for i, test := range tests {
		t.Run(fmt.Sprintf("Example %v", i+1), func(t *testing.T) {
			results := [][][]int{
				threeSum(test.Nums),
			}

			for _, actual := range results {
				if !reflect.DeepEqual(actual, test.Expected) {
					t.Errorf("Expected %v, got %v", test.Expected, actual)
				}
			}
		})
	}
}
