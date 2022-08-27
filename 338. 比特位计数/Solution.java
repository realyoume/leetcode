class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        ans[0] = 0;
        for (int i = 1; i <= n; ++i){
            ans[i] = ans[i >> 1] + i%2;
        }

        return ans;
    }
}

/*
    简单
    数字二进制表示中1的个数
    动态规划，用之前的结果来简化计算
 */