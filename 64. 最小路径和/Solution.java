class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] distance = new int[m][n];

        distance[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i){
            distance[i][0] = grid[i][0] + distance[i-1][0];
        }

        for (int i = 1; i < n; ++i){
            distance[0][i] = grid[0][i] + distance[0][i-1];
        }

        for (int i = 1; i < m; ++i){
            for (int j = 1; j < n; ++j){
                distance[i][j] = Math.min(distance[i-1][j],distance[i][j-1]) + grid[i][j];
            }
        }

        return distance[m-1][n-1];
    }
}

/*
    又是在一个正方形里面走，和上一个题有点类似
    用动态规划的方式来求得最短路径，空间换时间
 */