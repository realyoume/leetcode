package main

func main() {

}

func lengthOfLIS(nums []int) int {
	size := len(nums)
	if size == 0 {
		return 0
	}

	res := 1
	ans := make([]int, size)
	ans[0] = 1

	for i := 1; i < size; i++ {
		ans[i] = 1
		for j := 0; j < i; j++ {
			if nums[i] > nums[j] && ans[j]+1 > ans[i] {
				ans[i] = ans[j] + 1
			}
		}
		if ans[i] > res {
			res = ans[i]
		}
	}
	return res
}

/*
	使用动态规划，最重要的是找到状态转移方程
	把之前计算的结果记录下来，简便了后面的计算，最终的到答案
*/
