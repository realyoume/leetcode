package main

func main() {

}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
//	if root == nil {
//		return nil
//	}
//	if root.Val == p.Val || root.Val == q.Val {
//		return root
//	}
//
//	left := lowestCommonAncestor(root.Left, p, q)
//	right := lowestCommonAncestor(root.Right, p, q)
//
//	if left != nil && right != nil {
//		return root
//	}
//
//	if left == nil {
//		return right
//	}
//
//	return left
//}

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	parent := make(map[int]*TreeNode)
	visited := make(map[*TreeNode]bool)

	var dfs func(node *TreeNode)
	dfs = func(node *TreeNode) {
		if node.Left != nil {
			parent[node.Left.Val] = node
			dfs(node.Left)
		}
		if node.Right != nil {
			parent[node.Right.Val] = node
			dfs(node.Right)
		}
	}
	dfs(root)

	for p != nil {
		visited[p] = true
		p = parent[p.Val]
	}

	for q != nil {
		if visited[q] {
			return q
		}
		q = parent[q.Val]
	}

	return root
}

/*
	涉及到二叉树，首先就想到递归遍历
	寻找两个节点的共同祖节点
	分别在左右子树中寻找两个节点，如果恰好一边一个，那么说明此节点就是最深的公共祖先，将自己返回
	如果只有一边有，那么说明最深的公共祖先在这一边，且已经产生了
	如果一个节点发现自己符合要求，只要返回自己就行了，不用管自己的子节点有无符合要求的，

	还有一种解法比较好理解，效率也不差
	先进行一次深度优先遍历，用map来记录每一个节点的父节点
	对p的父节点进行遍历，用map来记录p的所有父节点
	再对q的父节点进行遍历，如果有被记录过的，说明这是公共祖先，由于我们是从下往上，那么这是最深的公共祖先
*/
