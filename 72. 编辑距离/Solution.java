class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int box[][] = new int[len1+1][len2+1];

        for (int i = 0; i <= len2; ++i) {
            box[0][i] = i;
        }

        for (int i = 0; i <= len1; ++i) {
            box[i][0] = i;
        }

        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    box[i][j] = 1 + Math.min(Math.min(box[i-1][j], box[i][j-1]), box[i-1][j-1] -1);
                }else {
                    box[i][j] = 1 + Math.min(Math.min(box[i-1][j], box[i][j-1]), box[i-1][j-1]);
                }
            }
        }

        return box[len1][len2];
    }
}

/*
72. 编辑距离
没写出来，感觉不知道怎么写，因为可能性太多了，以后这样的题都考虑一下动态规划
动态规划，首先是找到状态和基本状态，状态就是某种条件下对应的一个结果，它并不是最终的结果，而是一个弱化的、过程中的结果，
基础状态就是能够很容易得到答案的状态，它是其他状态得以发展的基础，一般是最特殊的情况，如0
然后就是状态转移方程，它从已知状态推出未知状态，像多米诺骨牌一样，一直推到最后的答案
什么时候用动态规划？一般是有许多可能性的情况，要考虑很多种情况
如何实现？用数组或多维数组，写好基础情况，按顺序遍历，依此求出结果。
 */