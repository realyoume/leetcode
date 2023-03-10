import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, int curr, int target){
        if (root == null){
            return 0;
        }

        curr += root.val;

        int num = prefix.getOrDefault(curr - target, 0);

        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        num += dfs(root.left, prefix, curr, target);
        num += dfs(root.right, prefix, curr, target);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return num;
    }


}