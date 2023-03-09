package main

func main() {
	isMatch("aaa", "a*a")
}

func isMatch(s string, p string) bool {
	m, n := len(s), len(p)

	match := func(i, j int) bool {
		if i == 0 {
			return false
		}

		if p[j-1] == '.' {
			return true
		}



		return s[i-1] == p[j-1]
	}

	a := make([][]bool, m+1)

	for i := 0; i < m+1; i++ {
		a[i] = make([]bool, n+1)
	}

	a[0][0] = true

	for i := 0; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if p[j-1] == '*' {
				a[i][j] = a[i][j] || a[i][j-2]
				if match(i, j-1) {
					a[i][j] = a[i][j] || a[i-1][j]
				}
			} else if match(i, j) {
				a[i][j] = a[i][j] || a[i-1][j-1]
			}
		}
	}

	return a[m][n]
}

/*
10. 正则表达式匹配
这是一道困难的题目，很久没有刷题了，遇到不少困难
匹配两个字符串，首先想到是逐位对比，有两个指针
但是因为有*，当面对*时，我们可以选择用或者不用，这样就有两种可能，也取决于之前的两种情况
所以我们将之前的对比情况存下来，这样作动态规划
综合起来，就可以判断当下情况能否到达，
最终结果取决于两个字符串是否都能到达串尾。

*/
