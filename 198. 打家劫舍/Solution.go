package main

func main() {

}

func rob(nums []int) int {
	length := len(nums)
	sum := make([]int, length)

	sum[0] = nums[0]
	if length == 1 {
		return sum[0]
	}
	sum[1] = max(nums[0], nums[1])
	if length == 2 {
		return sum[1]
	}

	for i := 2; i < length; i++ {
		sum[i] = max(nums[i]+sum[i-2], sum[i-1])
	}

	return sum[length-1]
}

func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

/*
	使用了动态规划，不断比较取最大值，
*/
