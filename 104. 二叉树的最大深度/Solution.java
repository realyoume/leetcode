class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}

/*
    比较简单，深度优先搜索来找到二叉树的深度，用递归的思想。
 */





