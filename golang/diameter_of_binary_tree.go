package golang

import "slices"

func diameterOfBinaryTree(root *TreeNode) int {
	var loop func(*TreeNode) [][]*TreeNode

	loop = func(node *TreeNode) [][]*TreeNode {
		if node == nil {
			return [][]*TreeNode{{}}
		}

		lss := loop(node.Left)
		lssGrown := slices.Clone(lss)
		for i := range lssGrown {
			if len(lssGrown[i]) == 0 || lssGrown[i][len(lssGrown[i])-1] == node.Left {
				lssGrown[i] = append(lssGrown[i], node)
			}
		}

		rss := loop(node.Right)
		rssGrown := slices.Clone(rss)
		for i := range rss {
			if len(rssGrown[i]) == 0 || rssGrown[i][len(rssGrown[i])-1] == node.Right {
				rssGrown[i] = append(rssGrown[i], node)
			}
		}

		var merged [][]*TreeNode

		for i := range lssGrown {
			for j := range rssGrown {
				ls := lssGrown[i]
				rs := rssGrown[j]

				if len(ls) > 0 && len(rs) > 0 && ls[len(ls)-1] == rs[len(rs)-1] {
					var m []*TreeNode
					m = append(m, ls...)
					m = append(m, rs[:len(rs)-1]...)
					merged = append(merged, m)
				}
			}
		}

		all := append(lssGrown, rssGrown...)
		all = append(all, merged...)
		return all
	}

	diameter := 0

	res := loop(root)

	for i := range res {
		if len(res[i]) > diameter {
			diameter = len(res[i])
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
