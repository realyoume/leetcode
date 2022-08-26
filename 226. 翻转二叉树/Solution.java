class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        invertTree(left);
        invertTree(right);

        root.left = right;
        root.right = left;

        return root;
    }
}

/*
    用递归来交换左右树
    时间复杂度O(n)，每个节点都要访问一次
    空间复杂度O(h)，h为树高，也就是栈的深度
 */