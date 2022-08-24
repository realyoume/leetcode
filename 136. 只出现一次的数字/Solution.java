import java.util.Arrays;

class Solution {
    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//
//        int len = nums.length;
//
//        for (int i = 0; i < len; i = i + 2){
//            if(i + 1 == len){
//                return nums[i];
//            }
//            if(nums[i] != nums[i+1]){
//                return nums[i];
//            }
//        }
//
//        return -1;

        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}

/*
    找到数组中只出现一次的数字
    解法当然有很多，可以用哈希表记录出现的次数，也可以先排序后再依此判断
    但是空间复杂度都很高
    如果用异或，那么两个相同的数字都会归零，异或又满足交换律，所以相同的数字都会最后抵消为0，而0与其他异或都不改变，最终剩下的就是只出现一次的数字
 */





