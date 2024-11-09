package golang_problems

// left, current, right
func inorderTraversal(root *TreeNode) []int {
	var res []int
	var stack []*TreeNode
	var current = root

	for current != nil || len(stack) > 0 {
		if current != nil {
			stack = append(stack, current)
			current = current.Left
		} else {
			current = stack[len(stack)-1]
			stack = stack[:len(stack)-1]

			res = append(res, current.Val)

			current = current.Right
		}
	}

	return res
}
