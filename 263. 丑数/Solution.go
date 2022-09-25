package main

var factor = []int{2, 3, 5}

func isUgly(n int) bool {
	//if n == 0 {
	//	return false
	//}
	//
	//for n%2 == 0 {
	//	n = n / 2
	//}
	//
	//for n%3 == 0 {
	//	n = n / 3
	//}
	//
	//for n%5 == 0 {
	//	n = n / 5
	//}
	//
	//if n == 1 {
	//	return true
	//} else {
	//	return false
	//}

	if n <= 0 {
		return false
	}

	for _, f := range factor {
		for n%f == 0 {
			n = n / f
		}
	}

	return n == 1
}

/*
	开始用Go语言刷题，主要是想熟悉一下
	今天先写了三道比较简单的题，重点是尝试一下Go的特点
	确实有很多不同，也有很多灵活的地方
	这道题和答案思路一样，但是答案写的更为简洁，用了表驱动的思想
	之后会慢慢了解Go的语法，并完善笔记供复习
*/
