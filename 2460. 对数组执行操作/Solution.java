class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                nums[i] += nums[i+1];
                nums[i+1] = 0;
            }
        }

        int slow = 0, fast = 0;

        while(fast < nums.length){
            if(nums[fast] != 0){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }

            fast++;
        }

        return nums;
    }
}