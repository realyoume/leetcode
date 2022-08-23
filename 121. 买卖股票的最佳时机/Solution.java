public class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}

/*
    没有做出来，看了解答之后觉得很巧妙
    只用一次遍历，找历史最小值（已经划过的数组中的最小值），同时算在当天卖出能得到的钱，
    求得最大值
 */







