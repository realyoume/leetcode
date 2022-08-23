//class Solution {
//    public boolean isSymmetric(TreeNode root) {
//        TreeNode left = root.left;
//        TreeNode right = root.right;
//
//        return isEqual(left,right);
//    }
//
//    public boolean isEqual(TreeNode t1, TreeNode t2){
//        if(t1 == null && t2 == null){
//            return true;
//        }else if(t1 == null || t2 == null){
//            return false;
//        }
//
//        if(t1.val != t2.val){
//            return false;
//        }
//
//        if(isEqual(t1.left,t2.right) && isEqual(t1.right,t2.left)){
//            return true;
//        }
//
//        return false;
//    }
//}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}

/*
 不难想到用递归的思想来做，题目给出的代码比我写的更为简单，因为合并了许多条件的判断直接返回，也更加直观。
 */







