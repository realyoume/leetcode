import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        ans.add(temp);

        for (int i = 0; i < len; ++i){
            int size = ans.size();

            for (int j = 0; j < size; ++j) {
                temp = new ArrayList<>(ans.get(j));
                temp.add(nums[i]);
                ans.add(temp);
            }
        }

        return ans;
    }
}

/*
    用一种答案没写的方式写出来了
    答案用的是回溯法，我这个应该是动态规划
    复杂度很好
 */