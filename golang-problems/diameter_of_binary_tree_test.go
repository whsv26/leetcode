package golang_problems

import (
	"fmt"
	"testing"
)

func Test_diameterOfBinaryTree(t *testing.T) {
	tests := []struct {
		Tree     string
		Diameter int
	}{
		{"1,2,3,4,5", 3},
		{"1,2", 1},
		{"4,2,null,1,3", 2},
	}

	for i, test := range tests {
		t.Run(fmt.Sprintf("Example %v", i+1), func(t *testing.T) {
			results := []int{
				diameterOfBinaryTree(NewTreeNode(test.Tree)),
			}

			for _, result := range results {
				if result != test.Diameter {
					t.Errorf("Expected %v, got %v", test.Diameter, result)
				}
			}

		})
	}
}
