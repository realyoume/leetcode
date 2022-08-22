class Solution {
    public int climbStairs(int n) {
        // 递归，复杂度太高
//        if(n == 1){
//            return 1;
//        }else if(n == 2){
//            return 2;
//        }else {
//            return  climbStairs(n - 1) + climbStairs(n - 2);
//        }


        // 实质上是一个斐波那契数列
        int l = 0;
        int m = 1;
        int r = 1;
        for (int i = 0 ; i < n; ++i){
            r = m + l;
            l = m;
            m = r;
        }

        return r;
    }
}