
import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int integer : nums) {
            set.add(integer);
        }

        int ans = 0;

        for (int integer : nums) {
            if (! set.contains(integer-1)){
                int len = 1;
                int target = integer;

                while(set.contains(target+1)){
                    target++;
                    len++;
                }

                ans = Math.max(ans, len);
            }
        }

        return ans;
    }

}