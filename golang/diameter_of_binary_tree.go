package golang

type Point struct {
	Node   *TreeNode
	Length int
}

func diameterOfBinaryTree(root *TreeNode) int {
	var loop func(*TreeNode) []*Point

	loop = func(node *TreeNode) []*Point {
		if node == nil {
			return []*Point{{nil, 0}}
		}

		lss := loop(node.Left)
		for _, ls := range lss {
			if ls.Length == 0 || ls.Node == node.Left {
				ls.Node = node
				ls.Length++
			}
		}

		rss := loop(node.Right)
		for _, rs := range rss {
			if rs.Length == 0 || rs.Node == node.Right {
				rs.Node = node
				rs.Length++
			}
		}

		var merged []*Point

		for _, ls := range lss {
			for _, rs := range rss {
				if ls.Node == rs.Node {
					merged = append(merged, &Point{nil, ls.Length + rs.Length - 1})
				}
			}
		}

		all := append(lss, rss...)
		all = append(all, merged...)
		return all
	}

	diameter := 0

	res := loop(root)

	for i := range res {
		if res[i].Length > diameter {
			diameter = res[i].Length
		}
	}

	return diameter - 1
}

//     4
//    /
//   2
//  / \
// 1   3

//[[1]] [[3]]
//[[1, 2], [2, 3], [1, 2, 3]]

//                   1
//                  / \
//                 2   11
//                / \
//               3   7
//              /   /  \
//             4   8    10
//            / \   \
//           5   6   9

// [[5]] [[6]]                                 [[9]]
// [[5, 4], [6, 4], [5, 4, 6]]                 [[9, 8]] [[10]]
// [[5, 4, 3], [6, 4, 3], [5, 4, 6]]           [[9, 8, 7], [10, 7], [9, 8, 7, 10]]
// [[5, 4, 3, 2], [6, 4, 3, 2], [5, 4, 6]]     [[9, 8, 7, 2], [10, 7, 2], [9, 8, 7, 10]]

// Grow left by n if n.left == last node
// Grow right by n if n.right == last node
// Merge left and right with n in the middle
