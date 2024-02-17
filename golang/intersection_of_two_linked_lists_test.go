package golang

import (
	"testing"
)

func Test_getIntersectionNode(t *testing.T) {
	intersection := makeListNode([]int{8, 4, 5})
	a := joinListNodes(makeListNode([]int{4, 1}), intersection)
	b := joinListNodes(makeListNode([]int{5, 6, 1}), intersection)

	if getIntersectionNode(a, b).Val != 8 {
		t.Error()
	}
}
