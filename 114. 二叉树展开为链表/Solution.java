import javax.swing.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;


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
//    public void flatten(TreeNode root) {
//        Deque<TreeNode> deque = new LinkedList<>();
//        TreeNode key = new TreeNode();
//        deque.push(root);
//
//        while(deque.peek() != null){
//            TreeNode temp = deque.poll();
//            if(temp.right != null){
//                deque.push(temp.right);
//            }
//            if (temp.left != null){
//                deque.push(temp.left);
//            }
//
//            key.right = temp;
//            key.left = null;
//            key = key.right;
//        }
//
//        return;
//    }

    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null){
            if(curr.left != null){
                TreeNode next = root.left;
                TreeNode pre = next;
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}

/*
    把二叉树用先序遍历的顺序转化为链表
    因为本身会改变二叉树的原有结构，所以我想了一种用栈记录节点的方式，先节点本身，再把右数压栈，左树压栈，这样就是先序遍历
    更为巧妙的答案是用前驱节点的思想，当我们进入左树改变结构时，会失去对右树的指针，因为是左树结束后遍历右树
    所以找到左树的最后一个节点，也就是右树的前驱节点，将其右边指向右树，这样就可以连续下去
 */