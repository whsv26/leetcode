package golang

import "math"

func diameterOfBinaryTree(root *TreeNode) int {
	var loop func(*TreeNode) (float64, float64)

	loop = func(node *TreeNode) (float64, float64) {
		if node == nil {
			return 0, 0
		}

		lx, ly := loop(node.Left)
		rx, ry := loop(node.Right)

		y := math.Max(ly, ry) + 1
		x := math.Max(lx, rx)
		x = math.Max(x, ly+ry+1)

		return x, y
	}

	x, y := loop(root)

	return int(math.Max(x, y)) - 1
}
