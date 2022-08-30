
public class TreeNode {
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1,root2);
    }

    public TreeNode merge(TreeNode r1,TreeNode r2){
        TreeNode ans = new TreeNode();

//        if (r1 == null && r2 == null){
//            return null;
//        }
        // 可以合并到下面去
        if(r1 == null){
            return r2;
        }
        if (r2 == null){
            return r1;
        }

        ans.val = r1.val + r2.val;
        ans.right = merge(r1.right, r2.right);
        ans.left = merge(r1.left, r2.left);

        return ans;
    }
}

/*
    二叉树的题目都是这样，深度递归遍历
    一直递归，判断边界条件，挺好写的
 */