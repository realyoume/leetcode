import javax.swing.tree.TreeNode;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//
//class Solution {
//    public Map<Integer, Integer> map = new HashMap<>();
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int len = preorder.length;
//        for (int i = 0; i < len; ++i) {
//            map.put(inorder[i], i);
//        }
//        return grow(preorder, inorder);
//    }
//
//    public TreeNode grow(int[] preorder, int[] inorder) {
//        int len = preorder.length;
//        if (len == 0) {
//            return null;
//        }
//        int val = preorder[0];
//        TreeNode temp = new TreeNode(val);
//
//        int root = map.get(val).intValue();
//
//
//        temp.left = grow(Arrays.copyOfRange(preorder, 1, root + 1), Arrays.copyOfRange(inorder, 0, root));
//        temp.right = grow(Arrays.copyOfRange(preorder, root + 1, len), Arrays.copyOfRange(inorder, root + 1, len));
//
//        return temp;
//    }
//
//    public static void main(String[] args) {
//        int[] preorder = {3,9,20,15,7};
//        int[] inorder = {9,3,15,20,7};
//        Solution solution = new Solution();
//        solution.buildTree(preorder,inorder);
//    }
//
//}

class Solution {
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}

/*
    用前序遍历和中序遍历生成一颗树
    大体思路反正是递归，确定根节点，再递归子树
    如果有多次遍历一个数组查找元素，那么可以先存储到map中，空间换时间，这样可以提升速度。
 */

