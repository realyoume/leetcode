package main

import "math"

func main() {

}

//
//func numSquares(n int) int {
//	ans := make([]int, n)
//	for i := 0; i < len(ans); i++ {
//		if check(i + 1) {
//			ans[i] = 1
//		} else {
//			ans[i] = math.MaxInt
//			l := 0
//			r := i - 1
//			for l <= r {
//				if ans[l]+ans[r] < ans[i] {
//					ans[i] = ans[l] + ans[r]
//				}
//				l++
//				r--
//			}
//		}
//	}
//
//	return ans[len(ans)-1]
//}
//
//func check(n int) bool {
//	m := int(math.Sqrt(float64(n)))
//	return m*m == n
//}

func numSquares(n int) int {
	ans := make([]int, n+1)
	ans[0] = 0

	for i := 1; i <= n; i++ {
		minn := math.MaxInt

		for j := 1; j*j <= i; j++ {
			minn = min(minn, ans[i-j*j])
		}
		ans[i] = minn + 1
	}
	return ans[n]

}

func min(a int, b int) int {
	if a > b {
		return b
	}
	return a
}

/*
	容易想到是动态规划，但是我还是写的比答案复杂一些
	答案的循环过程更加简练一些，还是我写复杂了，时间复杂了
*/
