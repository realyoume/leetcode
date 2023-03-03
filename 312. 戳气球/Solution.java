import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        maxCoins(new int[]{3,1,5,8});
    }
    public  static int maxCoins(int[] nums) {
       int n = nums.length;

       int[] arr = new int[n+2];

        for (int i = 0; i < n; ++i) {
            arr[i+1] = nums[i];
        }

        arr[0] = 1;
        arr[n+1]= 1;

        int[][] matrix = new int[n+2][n+2];
        for (int i = 0; i < n + 2; ++i) {
            Arrays.fill(matrix[i],-1);
        }

        return helper(arr, matrix, 0, arr.length-1);
    }

    public static int helper(int[] arr,int[][] matrix, int l, int r){
        if (l >= r-1){
            return 0;
        }

        if (matrix[l][r] != -1){
            return matrix[l][r];
        }


        for (int i = l+1; i < r; ++i) {
            int cnt = arr[l] * arr[i] *  arr[r];

            matrix[l][r] = Math.max(matrix[l][r], cnt + helper(arr,matrix,l,i) + helper(arr,matrix,i,r));
        }

        return matrix[l][r];
    }

}