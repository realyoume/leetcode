import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        largestValsFromLabels(new int[]{5,4,3,2,1}, new int[]{1,3,3,3,2}, 3, 2);
    }


    public static int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        if (numWanted == 0){
            return 0;
        }

        sort(values, labels, 0, values.length-1);

        Map<Integer, Integer> counter = new HashMap<>();
        int count = 0;
        int sum = 0;

        for (int i = values.length-1; i >= 0; --i) {
            if (count >= numWanted){
                break;
            }

            int time = counter.getOrDefault(labels[i], 0);
            if (time < useLimit){
                sum += values[i];
                counter.put(labels[i],time+1);
                count++;
            }
        }

        return sum;
    }

    public static void sort(int[] values, int[] labels, int left, int right){
        if (left >= right){
            return;
        }

        int slow = left, fast = left;
        int base = values[right];

        while (fast < right){
            if (values[fast] < base){
                swap(values, labels, fast, slow);
                slow++;
            }
            fast++;
        }

        swap(values, labels, right, slow);

        sort(values, labels, left, slow - 1);
        sort(values, labels, slow + 1, right);

    }

    public static void swap(int[] values, int[] labels, int m, int n){
        int temp = values[m];
        values[m] = values[n];
        values[n] = temp;

        temp = labels[m];
        labels[m] = labels[n];
        labels[n] = temp;
    }
}