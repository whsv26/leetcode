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

func Map[A any, B any](xs []A, f func(A) B) []B {
	bs := make([]B, len(xs))

	for i := range xs {
		bs[i] = f(xs[i])
	}

	return bs
}

func Filter[A any](xs []A, f func(A) bool) []A {
	bs := make([]A, 0, len(xs))

	for _, x := range xs {
		if f(x) {
			bs = append(bs, x)
		}
	}

	return bs
}
