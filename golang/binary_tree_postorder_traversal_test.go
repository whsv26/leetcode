package golang

import (
	"fmt"
	"reflect"
	"testing"
)

func Test_postorderTraversal(t *testing.T) {
	tests := []struct {
		Tree     string
		Expected []int
	}{
		{"1,null,2,3", []int{3, 2, 1}},
		{"", nil},
		{"1", []int{1}},
	}

	for i, test := range tests {
		t.Run(fmt.Sprintf("Example %v", i+1), func(t *testing.T) {
			actual := postorderTraversal(NewTreeNode(test.Tree))

			if !reflect.DeepEqual(actual, test.Expected) {
				t.Errorf("Expected %v, got %v", test.Expected, actual)
			}
		})
	}
}
