import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int p = nums.length - 1;

        while (p-1 >= 0){
            if (nums[p] > nums[p-1]){
                break;
            }
            p--;
        }

        if (p == 0){
            Arrays.sort(nums);
            return;
        }

        int target = p-1;
        int min = p;

        while(p < nums.length){
            if (nums[p] > nums[target] && nums[p] < nums[min]){
                min = p;
            }
            p++;
        }

        int temp = nums[target];
        nums[target] = nums[min];
        nums[min] = temp;

        Arrays.sort(nums, target+1, nums.length);
    }
}