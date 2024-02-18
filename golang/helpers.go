package golang

func MakeListNode(xxs ...[]int) (res *ListNode) {
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

func JoinListNodes(lhs *ListNode, rhs *ListNode) *ListNode {
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
