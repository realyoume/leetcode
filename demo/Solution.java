class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        if(n < 2){
            return false;
        }

        int sum = 0, maxNum = nums[0];
        for(int i = 0;i < n ; i++){
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }

        if(sum % 2 == 1){
            return false;
        }

        int target = sum / 2;
        if(target < maxNum){
            return false;
        }

        boolean[][] dp = new boolean[n][target+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for(int i = 1; i < n; i++){
            int num = nums[i];
            for(int j = 0; j < target+1; j++){
                if(j > num){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-num];
                }else{
                    dp[i][j] = dp[i-1][j] ;
                }
            }
        }


        return dp[n-1][target];
    }

}