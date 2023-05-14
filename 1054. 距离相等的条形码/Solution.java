import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int len = barcodes.length;
        int[] ans = new int[len];

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : barcodes) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int oddIndex = 1;
        int evenIndex = 0;

        for (Integer integer : map.keySet()) {
            int count = map.get(integer);

            while (count > 0 && count <= len / 2 && oddIndex < len){
                ans[oddIndex] = integer;

                oddIndex += 2;
                count--;
            }

            while (count > 0){
                ans[evenIndex] = integer;

                evenIndex += 2;
                count--;
            }
        }

        return ans;
    }
}