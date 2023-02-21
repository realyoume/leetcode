import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        maxEnvelopes(new int[][]{{1,2},{2,3},{3,4},{3,5},{4,5},{5,5},{5,6},{6,7},{7,8}});
    }

    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });

        int size = envelopes.length;
        int[] minInLen = new int[size+1];

        minInLen[1] = envelopes[0][1];
        int len = 1;

        for (int i = 1; i < size; ++i) {
            int target = envelopes[i][1];
            if (target > minInLen[len]){
                len++;
                minInLen[len] = target;
            }else {
                int l = 1, r = len;
                int ans = len;

                while (l <= r){
                    int mid = (l + r) >> 1;
                    if (minInLen[mid] >= target){
                        ans = mid;
                        r = mid - 1;
                    }else {
                        l = mid + 1;
                    }
                }

                minInLen[ans] = target;
            }
        }

        return len;
    }
}