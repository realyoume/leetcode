class Solution {
//    public int uniquePaths(int m, int n) {
//        if(m == 1 || n == 1){
//            return 1;
//        }
//
//        return uniquePaths(m-1,n) + uniquePaths(m, n-1);
//    }

    public int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];

        for (int i = 0; i < m; ++i){
            board[i][0] = 1;
        }

        for (int i = 0; i < n; ++i){
            board[0][i] = 1;
        }

        for (int i = 1; i < m; ++i){
            for (int j = 1; j < n; ++j){
                board[i][j] = board[i-1][j] + board[i][j-1];
            }
        }

        return board[m-1][n-1];
    }
}

/*
    拿到题一看，这不就是递归吗，写完一看，好吧，时间复杂度超了
    仔细一想，还得是动态规划，把所有结果用二维数组记录下来，这样之后就能用上
    用空间换了时间，挺简单一道题，说明了动态规划的作用
 */