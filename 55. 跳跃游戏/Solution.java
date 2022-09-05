//class Solution {
//    public boolean canJump(int[] nums) {
//        int len = nums.length;
//        int[] flag = new int[len];
//        flag[0] = 1;
//
//        for (int i = 0; i < len; ++i){
//            if (flag[i] == 1){
//                for (int j = 1; j <= nums[i] && i+j<len; ++j){
//                    flag[i+j] = 1;
//                }
//            }
//            if(flag[len - 1] == 1){
//                return true;
//            }
//        }
//        return false;
//    }
//}

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

/*
    一开始写的回溯法，可能是最近写的比较多。显然是复杂了
    后来想到了遍历，还是比标准答案复杂
    只用维护最远可到达位置就行了，最远位置的左边全部是可以到达的，因为跳跃的步数可以从一开始，那么中间不会出现空缺
    只要最远位置超过了数组最后一位，那么说明就是可到达的
 */