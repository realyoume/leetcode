class Solution {
//    public int numTrees(int n) {
//        int [] nums = new int[n];
//
//        if(n == 1) return 1;
//        if(n == 2) return 2;
//
//        nums[0] = 1;
//        nums[1] = 2;
//
//        for (int i = 2; i < n; ++i) {
//            int count = 0;
//            for (int j = 0; j <= i; ++j) {
//                if(j == 0 || j == i){
//                    count += nums[i-1];
//                }else {
//                    count += nums[j-1] * nums[i-j-1];
//                }
//            }
//            nums[i] = count;
//        }
//
//        return nums[n-1];
//    }


    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }


}

/*
  和答案一样的思路，动态规划
  只不过答案的构造让代码写起来简单一些，也少了一些边界判断
  还是想了一会才想出来的
 */

