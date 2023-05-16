import java.util.Arrays;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        minDifficulty(new int[]{6,5,4,3,2,1}, 2);
    }

    public static int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d){
            return -1;
        }

        int[]dp = new int[n];

        int max = jobDifficulty[0];
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, jobDifficulty[i]);
            dp[i] = max;
        }

        for (int i = 1; i < d; ++i) {
            int[] ndp = new int[n];
            Arrays.fill(ndp, Integer.MAX_VALUE);

            for (int j = i; j < n; ++j) {
                int ma = jobDifficulty[j];

                for (int k = j; k >= i; --k) {
                    ma = Math.max(ma, jobDifficulty[k]);
                    ndp[j] = Math.min(dp[k-1] + ma , ndp[j]);
                }
            }

            dp = ndp;
        }

        return dp[n-1];
    }
}
