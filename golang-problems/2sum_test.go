package golang_problems

import (
	"fmt"
	"reflect"
	"testing"
)

func Test_twoSum(t *testing.T) {
	tests := []struct {
		Nums     []int
		Target   int
		Expected []int
	}{
		{[]int{2, 7, 11, 15}, 9, []int{0, 1}},
		{[]int{3, 2, 4}, 6, []int{1, 2}},
	}

	for i, test := range tests {
		t.Run(fmt.Sprintf("Example %v", i+1), func(t *testing.T) {
			results := [][]int{
				twoSum(test.Nums, test.Target),
			}

			for _, actual := range results {
				if !reflect.DeepEqual(actual, test.Expected) {
					t.Errorf("Expected %v, got %v", test.Expected, actual)
				}
			}
		})
	}
}
