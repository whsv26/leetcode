package golang

// left, right, current
func postorderTraversal(root *TreeNode) []int {
	var res []int
	var stack []*TreeNode
	var current = root
	var last *TreeNode

	for current != nil || len(stack) > 0 {
		if current != nil {
			stack = append(stack, current)
			current = current.Left
		} else {
			peek := stack[len(stack)-1]

			if peek.Right != nil && peek.Right != last {
				current = peek.Right
			} else {
				res = append(res, peek.Val)
				stack = stack[:len(stack)-1]
				last = peek
			}
		}
	}

	return res
}
