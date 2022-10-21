package main

import (
	"fmt"
	"math"
)

func main() {
	coins := []int{1, 2, 5}
	amount := 11
	res := coinChange(coins, amount)

	fmt.Println(res)
}

func coinChange(coins []int, amount int) int {
	ans := make([]int, amount+1)
	ans[0] = 0

	for i := 1; i <= amount; i++ {
		ans[i] = math.MaxInt - 1
		for _, coin := range coins {
			if i-coin >= 0 {
				if ans[i-coin]+1 < ans[i] {
					ans[i] = ans[i-coin] + 1
				}
			}
		}
	}

	if ans[amount] == math.MaxInt-1 {
		return -1
	}
	return ans[amount]
}

/*
	经典的动态规划
*/
