import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Codec codec = new Codec();
        String serialize = codec.serialize(codec.deserialize("[1,2,3,null,null,4,5,6,7]"));
        System.out.println(serialize);


    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "[]";
        }
        int count = dfsCount(root);
        int find = 0;
        Deque<TreeNode> queue = new LinkedList<>();

        queue.offerLast(root);

        StringBuilder stringBuilder = new StringBuilder("[");
        while (!queue.isEmpty()){
            TreeNode temp = queue.pollFirst();

            if (temp == null){
                stringBuilder.append("null,");
            }else {
                stringBuilder.append(temp.val + ",");
                queue.offerLast(temp.left);
                queue.offerLast(temp.right);

                if (++find == count){
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
                    break;
                }
            }
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int dfsCount(TreeNode root){
        if (root == null){
            return 0;
        }

        return 1 + dfsCount(root.left) + dfsCount(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.substring(1,data.length()-1).split(",");

        Deque<TreeNode> queue = new LinkedList<>();

        if (datas[0].equals("")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        queue.offerLast(root);

        int index = 1;
        while (index < datas.length){
            TreeNode temp = queue.pollFirst();


            if (! datas[index].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(datas[index]));
                queue.offerLast(left);
                temp.left = left;
            }



            if (++index >= datas.length){
                break;
            }


            if (! datas[index].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(datas[index]));
                queue.offerLast(right);
                temp.right = right;
            }



            index++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));