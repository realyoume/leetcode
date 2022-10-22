package main

func main() {

}

func maxProfit(prices []int) int {
	size := len(prices)

	if size == 1 || size == 0 {
		return 0
	}

	// k1 当天持有股票
	// k2 当天卖出股票，处于冷冻期
	// k3 当天没有股票，且不处于冷冻期

	// 初始化为第一天的状态
	k1, k2, k3 := -prices[0], 0, 0

	for i := 1; i < size; i++ {
		n1 := max(k1, k3-prices[i])
		n2 := k1 + prices[i]
		n3 := max(k2, k3)

		k1, k2, k3 = n1, n2, n3
	}

	return max(k2, k3)
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}

/*
	这也是一道动态规划的题，这几天写的比较多，但是还是没有想到该如何去做
	看来答案后也很快写出来了，这题和以前DP不同的事，它同时规划了多个状态，因为在多个状态中存在着转化，同一时间下可以有多个状态
	需要保存的是当前时间下的最大收益，我们每一次迭代就考虑最大收益就行
	在三个状态下相互转换，可以求得最大的收益
*/
