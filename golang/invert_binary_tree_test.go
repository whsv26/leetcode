package golang

import (
	"fmt"
	"testing"
)

func Test_invertTree(t *testing.T) {
	tests := []struct {
		Tree         string
		ReversedTree string
	}{
		{"4,2,7,1,3,6,9", "4,7,2,9,6,3,1"},
		{"2,1,3", "2,3,1"},
	}

	for i, test := range tests {
		t.Run(fmt.Sprintf("Example %v", i+1), func(t *testing.T) {
			codec := Codec{}
			results := []*TreeNode{
				invertTree(codec.deserialize(test.Tree)),
			}

			for _, result := range results {
				actual := codec.serialize(result)
				if actual != test.ReversedTree {
					t.Errorf("Expected %v, got %v", test.ReversedTree, actual)
				}
			}

		})
	}
}
