import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
         
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            
            int target = - nums[i];
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right){
                if (nums[left] + nums[right] == target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    
                    ans.add(temp);
                    
                    while (left+1 < nums.length && nums[left] == nums[left+1]){
                        left++;
                    }

                    left++;
                }else if (nums[left] + nums[right] < target){
                    left++;
                }else if (nums[left] + nums[right] > target){
                    right--;
                }
            }
        
        }

        return ans;
    }
}