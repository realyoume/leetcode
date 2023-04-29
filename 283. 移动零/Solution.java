class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;

        int fast = 0, slow = 0;

        while(fast < len){
            if (nums[fast] != 0 ){
                nums[slow] = nums[fast];
                slow++;
            }

            fast++;
        }

        while (slow < len){
            nums[slow] = 0;
            slow++;
        }
    }
}