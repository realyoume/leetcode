package main

func main() {

}

func productExceptSelf(nums []int) []int {
	size := len(nums)

	if size == 0 || size == 1 {
		return nums
	}

	ans, left, right := make([]int, size), make([]int, size), make([]int, size)

	left[0] = nums[0]
	right[size-1] = nums[size-1]

	for i := 1; i < size-1; i++ {
		left[i] = left[i-1] * nums[i]
		right[size-1-i] = right[size-i] * nums[size-1-i]
	}

	ans[0] = right[1]
	ans[size-1] = left[size-2]

	for i := 1; i < size-1; i++ {
		ans[i] = left[i-1] * right[i+1]
	}

	return ans
}

/*
	写法上大体思路和答案一致，就是在边界的处理上不同，总体出来的效果是一样的
	还有一种方法可以少用一些空间，利用了答案的数组，并按时间依此表示另一个数组的数
*/
