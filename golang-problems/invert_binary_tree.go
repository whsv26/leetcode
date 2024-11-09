package golang_problems

func invertTree(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}

	currentLevel := []*TreeNode{root}

	for len(currentLevel) > 0 {
		nextLevel := make([]*TreeNode, 0, len(currentLevel)*2)

		for _, node := range currentLevel {
			if node != nil {
				nextLevel = append(nextLevel, node.Left, node.Right)
				left := node.Left
				node.Left = node.Right
				node.Right = left
			}
		}
		currentLevel = nextLevel
	}

	return root
}
