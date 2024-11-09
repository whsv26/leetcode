package golang_problems

import (
	"fmt"
	"strconv"
	"strings"
)

type Codec struct{}

func Constructor() Codec {
	return Codec{}
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
	queue := []*TreeNode{root}

	var builder strings.Builder
	length := builder.Len()

	for len(queue) > 0 {
		node := queue[0]
		queue = queue[1:]

		if node == nil {
			builder.WriteString("null")
		} else {
			queue = append(queue, node.Left)
			queue = append(queue, node.Right)
			builder.WriteString(fmt.Sprintf("%v", node.Val))
			length = builder.Len()
		}

		builder.WriteString(",")
	}

	return builder.String()[0:length]
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
	parse := func(node string) *TreeNode {
		val, err := strconv.Atoi(node)
		if err != nil {
			return nil
		}
		return &TreeNode{Val: val}
	}

	next := func() *TreeNode {
		var node string
		if comma := strings.IndexRune(data, ','); comma != -1 {
			node = data[:comma]
			data = data[comma+1:]
		} else {
			node = data
			data = ""
		}

		return parse(node)
	}

	var parents []*TreeNode
	root := next()

	if root != nil {
		parents = append(parents, root)
	}

	for len(parents) > 0 {
		var children []*TreeNode
		for _, parent := range parents {
			if left := next(); left != nil {
				parent.Left = left
				children = append(children, left)
			}

			if right := next(); right != nil {
				parent.Right = right
				children = append(children, right)
			}
		}

		parents = children
	}

	return root
}
