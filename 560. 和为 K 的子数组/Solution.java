import java.util.HashMap;
import java.util.Map;

class Solution {


    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> counter = new HashMap<>();
        counter.put(0, 1);

        int ans = 0;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];

            counter.put(sum, counter.getOrDefault(sum, 0) + 1);

            if (counter.containsKey(k - sum)){
                ans += counter.get(k - sum);
            }
        }

        return ans;
    }
}