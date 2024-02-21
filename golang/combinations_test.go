package golang

import (
	"fmt"
	"reflect"
	"testing"
)

func Test_combinations(t *testing.T) {
	tests := []struct {
		K        int
		Nums     []int
		Expected [][]int
	}{
		{3, []int{1, 2, 3, 4, 5}, [][]int{{1, 2, 3}, {1, 2, 4}, {1, 2, 5}, {1, 3, 4}, {1, 3, 5}, {1, 4, 5}, {2, 3, 4}, {2, 3, 5}, {2, 4, 5}, {3, 4, 5}}},
		{2, []int{1, 2, 3, 4, 5}, [][]int{{1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {3, 4}, {3, 5}, {4, 5}}},
	}

	for i, test := range tests {
		t.Run(fmt.Sprintf("Example %v", i+1), func(t *testing.T) {
			results := [][][]int{
				combinations(test.Nums, test.K),
			}

			for _, actual := range results {
				if !reflect.DeepEqual(actual, test.Expected) {
					t.Errorf("Expected %v, got %v", test.Expected, actual)
				}
			}
		})
	}
}
