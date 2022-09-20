import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;


class Solution {
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//
//        if (root.right == null && root.left == null) {
//            return true;
//        }
//
//        if (root.right == null && root.left != null) {
//            TreeNode temp = root.left;
//            while (temp.right != null) {
//                temp = temp.right;
//            }
//            return root.val > temp.val && isValidBST(root.left);
//        }
//
//        if (root.right != null && root.left == null) {
//            TreeNode temp = root.right;
//            while (temp.left != null) {
//                temp = temp.left;
//            }
//            return root.val < temp.val && isValidBST(root.right);
//        }
//
//        if (root.right != null && root.left != null) {
//            TreeNode temp1 = root.right;
//            while (temp1.left != null) {
//                temp1 = temp1.left;
//            }
//            TreeNode temp2 = root.left;
//            while (temp2.right != null) {
//                temp2 = temp2.right;
//            }
//            return root.val < temp1.val && root.val > temp2.val &&
//                    isValidBST(root.right) && isValidBST(root.left);
//        }
//
//        return true;
//    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

}

/*
    自己写了一个，虽然复杂度不算太高，但是和答案比太复杂了
    也有用中序遍历的，二叉搜索树中序遍历就是升序的
 */