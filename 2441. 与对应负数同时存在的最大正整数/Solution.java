import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;

        while (left < right){
            if (nums[left] + nums[right] == 0){
                return nums[right];
            }else if (nums[left] + nums[right] > 0){
                right--;
            }else if (nums[left] + nums[right] < 0){
                left++;
            }
        }

        return -1;
    }
}