package golang_problems

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
		{3, []int{-1, 0, 1, 2, -1, -4}, [][]int{
			// -1 branch
			{-1, 0, 1}, {-1, 0, 2}, {-1, 0, -1}, {-1, 0, -4},
			{-1, 1, 2}, {-1, 1, -1}, {-1, 1, -4},
			{-1, 2, -1}, {-1, 2, -4},
			{-1, -1, -4},

			// 0 branch
			{0, 1, 2}, {0, 1, -1}, {0, 1, -4},
			{0, 2, -1}, {0, 2, -4},
			{0, -1, -4},

			// 1 branch
			{1, 2, -1}, {1, 2, -4},
			{1, -1, -4},

			// 2 branch
			{2, -1, -4},
		}},
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

func Test_combine(t *testing.T) {
	tests := []struct {
		N        int
		K        int
		Expected [][]int
	}{
		{4, 2, [][]int{{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}}},
		{1, 1, [][]int{{1}}},
	}

	for i, test := range tests {
		t.Run(fmt.Sprintf("Example %v", i+1), func(t *testing.T) {
			results := [][][]int{
				combine(test.N, test.K),
			}

			for _, actual := range results {
				if !reflect.DeepEqual(actual, test.Expected) {
					t.Errorf("Expected %v, got %v", test.Expected, actual)
				}
			}
		})
	}
}
