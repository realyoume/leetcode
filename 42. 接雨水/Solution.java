import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int trap(int[] height) {
        LinkedList<int[]> left = new LinkedList<>();
        LinkedList<int[]> right = new LinkedList<>();

        int len = height.length;
        for (int i = 0; i < len; ++i) {
            if (left.isEmpty() || left.peekLast()[0] <= height[i]){
                left.offerLast(new int[]{height[i], i});
            }

            if (right.isEmpty() || right.peekLast()[0] < height[len-1-i]){
                right.offerLast(new int[]{height[len-1-i], len-1-i});
            }
        }

        int sum = 0;

        while (left.size() >= 2){
            int[] low = left.pollFirst();
            int[] high = left.peekFirst();

            sum += low[0] * (high[1] - low[1] - 1);

            for (int i = low[1]+1; i < high[1]; ++i) {
                sum -= height[i];
            }
        }

        while (right.size() >= 2){
            int[] low = right.pollFirst();
            int[] high = right.peekFirst();

            sum += low[0] * (low[1] - high[1] - 1);

            for (int i = high[1]+1; i < low[1]; ++i) {
                sum -= height[i];
            }
        }

        return sum;
    }
}