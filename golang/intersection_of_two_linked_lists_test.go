package main

import (
	"testing"
)

func Test_getIntersectionNode(t *testing.T) {
	intersection := makeList([]int{8, 4, 5})
	a := joinLists(makeList([]int{4, 1}), intersection)
	b := joinLists(makeList([]int{5, 6, 1}), intersection)

	if getIntersectionNode(a, b).Val != 8 {
		t.Error()
	}
}

func makeList(xxs ...[]int) (res *ListNode) {
	tmp := &ListNode{}
	res = tmp

	for i := range xxs {
		for j := range xxs[i] {
			tmp.Next = &ListNode{xxs[i][j], nil}
			tmp = tmp.Next
		}
	}

	return res.Next
}

func joinLists(lhs *ListNode, rhs *ListNode) *ListNode {
	if lhs == nil {
		return rhs
	}

	res := lhs

	for lhs.Next != nil {
		lhs = lhs.Next
	}

	lhs.Next = rhs

	return res
}
