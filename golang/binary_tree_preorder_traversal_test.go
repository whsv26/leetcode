package golang

import (
	"fmt"
	"reflect"
	"testing"
)

func Test_preorderTraversal(t *testing.T) {
	tests := []struct {
		Tree     string
		Expected []int
	}{
		{"1,null,2,3", []int{1, 2, 3}},
		{"", nil},
		{"1", []int{1}},
		{"3,1,2", []int{3, 1, 2}},
	}

	for i, test := range tests {
		t.Run(fmt.Sprintf("Example %v", i+1), func(t *testing.T) {
			actual := preorderTraversal(NewTreeNode(test.Tree))

			if !reflect.DeepEqual(actual, test.Expected) {
				t.Errorf("Expected %v, got %v", test.Expected, actual)
			}
		})
	}
}
