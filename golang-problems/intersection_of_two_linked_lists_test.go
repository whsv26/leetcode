package golang_problems

import (
	"testing"
)

func Test_getIntersectionNode(t *testing.T) {
	intersection := MakeListNode([]int{8, 4, 5})
	a := JoinListNodes(MakeListNode([]int{4, 1}), intersection)
	b := JoinListNodes(MakeListNode([]int{5, 6, 1}), intersection)

	if getIntersectionNode(a, b).Val != 8 {
		t.Error()
	}
}
