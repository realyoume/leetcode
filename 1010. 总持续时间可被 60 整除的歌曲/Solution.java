import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        numPairsDivisibleBy60(new int[]{30,20,150,100,40});
    }

    public static int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        for (int t : time) {
            int val = t % 60;

            ans += map.getOrDefault((60 - val) % 60, 0);

            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        return ans;
    }
}