import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;

class Solution {


    public TreeNode convertBST(TreeNode root) {
        int sum = 0;

        TreeNode temp = root;

        while (temp != null){
            if (temp.right == null){
                sum += temp.val;
                temp.val = sum;
                temp = temp.left;
            }else {
                TreeNode succ = getSucc(temp);
                if (succ.left != temp){
                    succ.left = temp;
                    temp = temp.right;
                }else {
                    succ.left = null;
                    sum += temp.val;
                    temp.val = sum;
                    temp = temp.left;
                }
            }
        }

        return root;
    }

    public TreeNode getSucc(TreeNode node){
        TreeNode temp = node.right;
        while (temp.left != null && temp.left != node){
            temp = temp.left;
        }
        return temp;
    }



}