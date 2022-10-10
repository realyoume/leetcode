package main

func main() {
	matrix := [][]byte{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}
	maximalSquare(matrix)
}

func maximalSquare(matrix [][]byte) int {
	m := len(matrix)
	n := len(matrix[0])
	max := 0
	ans := make([][]int, m)

	for i := 0; i < m; i++ {
		ans[i] = make([]int, n)
		for j := 0; j < n; j++ {
			ans[i][j] = int(matrix[i][j] - '0')
			if ans[i][j] == 1 {
				max = 1
			}
		}
	}

	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			if ans[i][j] == 1 {
				ans[i][j] = min(ans[i-1][j], ans[i][j-1], ans[i-1][j-1]) + 1
				if ans[i][j] > max {
					max = ans[i][j]
				}
			}
		}
	}

	return max * max
}

func min(x, y, z int) int {
	if x < y {
		y = x
	}
	if y < z {
		z = y
	}
	return z
}

/*
	一开始用暴力法，没有完成，应该想到用动态规划的，但是还是没想出来
	最后看了答案，写了出来，发现go的二维数组还要这样创建，一开始写的还用了go的break标签特性，很有用
*/
