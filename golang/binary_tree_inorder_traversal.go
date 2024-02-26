package golang

// left, current, right
func inorderTraversal(root *TreeNode) []int {
	var res []int
	var stack []*TreeNode
	var current *TreeNode

	if root != nil {
		current = root
	}

	for current != nil || len(stack) > 0 {
		for current != nil {
			stack = append(stack, current)
			current = current.Left
		}

		current = stack[len(stack)-1]
		stack = stack[:len(stack)-1]

		res = append(res, current.Val)

		current = current.Right
	}

	return res
}
