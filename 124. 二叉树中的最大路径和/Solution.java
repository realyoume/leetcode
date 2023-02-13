import javax.swing.tree.TreeNode;

class Solution {

    public int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int dfs = dfs(root);

        return ans;
    }

    public int dfs(TreeNode node){
        if (node == null){
            return 0;
        }

        int l = dfs(node.left);
        int r = dfs(node.right);

        ans = Math.max(ans, l + r + node.val);

        int rs = Math.max(l + node.val, Math.max(r + node.val, node.val));
        ans = Math.max(ans, rs);

        return rs;
    }
}