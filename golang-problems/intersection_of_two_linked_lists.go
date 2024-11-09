package golang_problems

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	aLength := count(headA)
	bLength := count(headB)

	if diff := aLength - bLength; diff > 0 {
		headA = skip(headA, diff)
	} else if diff < 0 {
		headB = skip(headB, -diff)
	}

	var res *ListNode

	for headA != nil {
		if headA != headB {
			res = nil
		} else if res == nil {
			res = headA
		}

		headA = headA.Next
		headB = headB.Next
	}

	return res
}

func skip(head *ListNode, by int) *ListNode {
	for i := 0; head != nil && i < by; i++ {
		head = head.Next
	}

	return head
}

func count(head *ListNode) (qty int) {
	for ; head != nil; qty++ {
		head = head.Next
	}

	return qty
}
