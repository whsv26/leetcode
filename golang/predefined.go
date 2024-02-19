package golang

type Pair[A any, B any] struct {
	First  A
	Second B
}

type ListNode struct {
	Val  int
	Next *ListNode
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func NewTreeNode(data string) *TreeNode {
	constructor := Constructor()
	return constructor.deserialize(data)
}
