class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        int sum = dfs(root, limit, 0);

        if (sum < limit){
            root = null;
        }

        return root;
    }

    public int dfs(TreeNode root, int limit, int sum){
       if (root.left == null && root.right == null){
           return sum + root.val;
       }else if (root.left == null){
           int rightTree = dfs(root.right, limit, sum + root.val);

           if (rightTree < limit){
               root.right = null;
           }

           return rightTree;
       }else if (root.right == null){
           int leftTree = dfs(root.left, limit, sum + root.val);

           if (leftTree < limit){
               root.left = null;
           }

           return leftTree;
       }

        sum = sum + root.val;

        int leftTree = dfs(root.left, limit, sum);

        if (leftTree < limit){
            root.left = null;
        }

        int rightTree = dfs(root.right, limit, sum);

        if (rightTree < limit){
            root.right = null;
        }

        int max = Math.max(leftTree, rightTree);

        return max;
    }
}