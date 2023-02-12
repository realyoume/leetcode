import javax.swing.tree.TreeNode;


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
//    public int rob(TreeNode root) {
//        if (root == null){
//            return 0;
//        }
//
//        int ans0,ans1;
//        if(root.right == null && root.left == null){
//            return root.val;
//        } else if (root.right == null) {
//            ans0 = rob(root.left);
//            ans1 =  root.val + rob(root.left.left) + rob(root.left.right);
//        }else if (root.left == null){
//            ans0 = rob(root.right);
//            ans1 = root.val + rob(root.right.left) + rob(root.right.right);
//        }else {
//            ans0 = rob(root.left) + rob(root.right);
//            ans1 = root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right);
//        }
//
//        return ans0 > ans1 ? ans0 : ans1;
//    }

    public int rob(TreeNode root){
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1] );
    }

    public int[] dfs(TreeNode node){
        if (node == null){
            return new int[]{0, 0};
        }

        int[] n1 = dfs(node.left);
        int[] n2 = dfs(node.right);

        int y = node.val + n1[1] + n2[1];
        int n = Math.max(n1[0], n1[1]) + Math.max(n2[0], n2[1]);

        return new int[]{y, n};
    }
}

