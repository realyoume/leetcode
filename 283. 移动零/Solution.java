class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int slow = 0;
        int fast = 0;

        while (fast < len){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }

        for (int i = slow; i < len; ++i){
            nums[i] = 0;
        }
    }
}

/*
    比较简单的快慢指针
    慢指针指向已经满足条件的队列的最后，等待插入
    快指针向后判断是否满足条件，如果满足，则插入慢指针的位置，一直到末尾
    最后全部赋值0
 */