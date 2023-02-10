class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0){
            return 0;
        }

        int n = matrix[0].length;

        int [][] left = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1'){
                    left[i][j] = j == 0 ? 1 : left[i][j-1] + 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '0'){
                    continue;
                }

                int width = left[i][j];

                for (int k = i; k >= 0; --k) {
                    width = Math.min(width, left[k][j]);
                    ans = Math.max(ans, width* (i-k+1));
                }
            }
        }

        return ans;
    }
}

/*
85. 最大矩形
看了答案觉得也不难，就是做的时候想不到这样去做，好多题目都是这样的
考虑了动态规划，但是也不知道怎么写，一看答案竟然和昨天做的题有关
矩形的面积是由长和宽决定的，
这里是枚举了矩形右下角，这样依此确定长和宽
之前的那道题是是枚举矩形的高
 */