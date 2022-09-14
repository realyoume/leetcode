class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int fast = 0, slow = 0;
        int temp;

        while (fast < len){
            if(nums[fast] == 0){
                temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                ++slow;
            }
            ++fast;
        }

        fast = slow;

        while (fast < len){
            if(nums[fast] == 1){
                temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                ++slow;
            }
            ++fast;
        }
    }
}

/*
    一个经典的问题，我用了两个指针两次循环写出来了，时间复杂度不高
    其实可以用一次循环搞定，原理也不是很难
 */