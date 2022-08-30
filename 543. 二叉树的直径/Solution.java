
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        maxIn(root);
        return ans - 1;
    }

    public int maxIn(TreeNode node){
        if(node == null){
            return 0;
        }

        int l = maxIn(node.left);
        int r = maxIn(node.right);

        ans = Math.max(ans, l + r + 1);

        return Math.max(l, r) + 1;
    }
}

/*
   写的和标准答案差不多，深度遍历
   以每个节点为根的最大值，和这个节点下面的深度，递归进行遍历
 */