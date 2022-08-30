class Solution {
    public int hammingDistance(int x, int y) {
        // 依此比较
//        int count = 0;
//
//        while (!(x == 0 && y == 0)){
//            if(x % 2 != y % 2){
//                ++count;
//            }
//            x = x >> 2;
//            y = y >> 2;
//        }
//
//        return count;

        return Integer.bitCount(x ^ y);
        // bigCount 统计二进制表达中的1的个数
    }
}

/*
    自己写的时间复杂度也不高
    标准答案里面直接用异或得到了不相同的个数，然后调用系统内置函数得到1的个数
    也可以自己写一个依此得到1的个数
 */