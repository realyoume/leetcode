package main

func main() {

}

func findDuplicate(nums []int) int {
	size := len(nums)
	ans := make([]int, size)

	for _, val := range nums {
		ans[val]++
		if ans[val] == 2 {
			return val
		}
	}

	return -1
}

/*
	这道题意义不大，就这样做了
*/
