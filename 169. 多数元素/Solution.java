import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        // 0 自己写的，排序后找长串的相同元素
//        Arrays.sort(nums);
//
//        int len = nums.length;
//        if(len == 1){
//            return nums[0];
//        }
//
//        int count = 1;
//        for (int i = 0; i < len; ++i){
//            if(nums[i] == nums[i+1]){
//                ++count;
//                if(count > len/2){
//                    return nums[i];
//                }
//            }else {
//                count = 1;
//            }
//
//        }
//
//        return -1;

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

/*
    1 遍历数组，哈希表计数，得到出现最多次的数字
    2 先排序。因为数字出现的次数在一半以上，那么一定会占据数组n/2的位置
    3 随机选择一个数作为答案，然后验证，因为最多数出现次数很多，能抽到的概率很大
    4 投票算法，支持人数最多的数字就是最多数，遇到相同的加一，遇到不同的减一，为零后重新选举，因为最多数超过了总数的一半，与其他数字都相抵消后还有剩余，最坏情况下也能实现
 */