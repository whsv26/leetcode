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

	if len(data) == 0 {
		return nil
	}

	stringNodes := strings.Split(data, ",")
	nodes := make([]*TreeNode, len(stringNodes))

	for i, node := range stringNodes {
		if node == "null" {
			nodes[i] = nil
		} else {
			val, err := strconv.Atoi(node)
			if err != nil {
				nodes[i] = nil
			}
			nodes[i] = &TreeNode{Val: val}
		}
	}

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
