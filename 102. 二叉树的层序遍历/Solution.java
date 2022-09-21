import javax.swing.tree.TreeNode;
import java.util.*;


class Solution {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> ans = new ArrayList<>();
//
//        dfs(root, ans, 1);
//
//        return ans;
//    }
//
//    public void dfs(TreeNode root, List<List<Integer>> ans, int deep){
//        if(root == null){
//            return;
//        }
//
//        if(ans.size() >= deep){
//            List<Integer> temp = ans.get(deep-1);
//            temp.add(root.val);
//            ans.set(deep-1, temp);
//        }else {
//            List<Integer> temp = new ArrayList<>();
//            temp.add(root.val);
//            ans.add(temp);
//        }
//
//        dfs(root.left, ans, deep+1);
//        dfs(root.right, ans, deep+1);
//    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            if (root == null) {
                return ret;
            }

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<Integer>();
                int currentLevelSize = queue.size();
                for (int i = 1; i <= currentLevelSize; ++i) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                ret.add(level);
            }

            return ret;
        }
    }
}

/*
  按层数来遍历，本来应该广度优先搜索的，但是我用的还是递归写的深度优先搜索加上层数的标记，也能写出来，效果也不差
  如果是广度遍历，维护一个队列，因为要按层数分隔，所以每一次遍历时记录层中的数目，数完后直接进入下一层
  每一层维护一个数字，总体上还是广度遍历，只不过按层数拆开了，这样也好理解一些
 
 */
