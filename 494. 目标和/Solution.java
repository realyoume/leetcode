class Solution {

    public  int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum < target || (sum - target) % 2 != 0){
            return 0;
        }

        int neg = (sum - target) / 2;
        int[][] matrix = new int[n+1][neg + 1];
        int base = sum;

        matrix[0][0] = 1;


        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= neg; ++j) {
                matrix[i][j] += matrix[i-1][j];

                if (nums[i-1] <= j){
                    matrix[i][j] += matrix[i-1][j-nums[i-1]];
                }
            }
        }

        return matrix[n][neg];
    }
}