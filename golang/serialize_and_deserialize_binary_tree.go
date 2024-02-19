package golang

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
	currentLevel := []*TreeNode{root}

	var builder strings.Builder

	builder.WriteString("[")

	for len(currentLevel) > 0 {
		nextLevel := make([]*TreeNode, 0, len(currentLevel))
		isLastLevel := true
		lastNodeIdx := -1

		for i, cur := range currentLevel {
			if cur != nil {
				isLastLevel = isLastLevel && cur.Left == nil && cur.Right == nil
				nextLevel = append(nextLevel, cur.Left)
				nextLevel = append(nextLevel, cur.Right)
				lastNodeIdx = i
			}
		}

		if isLastLevel {
			currentLevel = currentLevel[:lastNodeIdx+1]
		}

		for i, cur := range currentLevel {
			if cur == nil {
				builder.WriteString("null")
			} else {
				builder.WriteString(fmt.Sprintf("%v", cur.Val))
			}

			if i < len(currentLevel)-1 || !isLastLevel {
				builder.WriteString(",")
			}
		}

		if !isLastLevel {
			currentLevel = nextLevel
		} else {
			currentLevel = nil
		}
	}

	builder.WriteString("]")

	return builder.String()
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
	data = strings.Trim(data, "[]")

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
