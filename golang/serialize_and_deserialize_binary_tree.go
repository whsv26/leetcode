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
		isEmptyLevel := true

		for i, cur := range currentLevel {
			val := "null"

			if cur != nil {
				isEmptyLevel = isEmptyLevel && (cur.Left == nil || cur.Right == nil)
				nextLevel = append(nextLevel, cur.Left)
				nextLevel = append(nextLevel, cur.Right)
				val = fmt.Sprintf("%v", cur.Val)
			}

			builder.WriteString(val)

			if i < len(currentLevel)-1 || !isEmptyLevel {
				builder.WriteString(",")
			}
		}

		if !isEmptyLevel {
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

	if len(data) == 0 {
		return nil
	}

	stringNodes := strings.Split(data, ",")

	nodes := Map(stringNodes, func(node string) *TreeNode {
		if node == "null" {
			return nil
		} else {
			val, err := strconv.Atoi(node)
			if err != nil {
				return nil
			}
			return &TreeNode{Val: val}
		}
	})

	for i, j := 0, 1; i < len(nodes); {
		if nodes[i] == nil {
			i++
			continue
		}

		node := nodes[i]

		if j < len(nodes) {
			node.Left = nodes[j]
		}
		if j+1 < len(nodes) {
			node.Right = nodes[j+1]
		}
		i++
		j += 2
	}

	return nodes[0]
}
