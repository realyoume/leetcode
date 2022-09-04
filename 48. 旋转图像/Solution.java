class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0; i < len/2; ++i ){
            for (int j = 0; j < len - 1 -  2*i; ++j){
                int temp = matrix[i][i+j];
                matrix[i][i+j] = matrix[len-1-i-j][i];
                matrix[len-1-i-j][i] = matrix[len-1-i][len-1-i-j];
                matrix[len-1-i][len-1-i-j] = matrix[i+j][len-1-i];
                matrix[i+j][len-1-i] = temp;
            }
        }
    }
}

/*
    不使用额外空间将矩阵旋转
    于是只好一个一个个来转，调试了几次，终于改对了
    还可以先水平翻转，再对角线反转来实现，代码要好写一些。
 */