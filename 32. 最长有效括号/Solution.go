package main

func main() {

}

//
//func longestValidParentheses(s string) int {
//	sLen := len(s)
//
//	longest := 0
//	for i := 0; i < sLen; i++ {
//		if s[i] == '(' {
//			r := 0
//			l := 0
//			for j := i; j < sLen; j++ {
//				if s[j] == '(' {
//					l++
//				} else {
//					r++
//				}
//
//				if l < r {
//					break
//				} else if l == r && l+r > longest {
//					longest = l + r
//				}
//			}
//		}
//	}
//
//	return longest
//}

func longestValidParentheses(s string) int {
	sLen := len(s)

	l, r, longest := 0, 0, 0
	for i := 0; i < sLen; i++ {
		if s[i] == '(' {
			l++
		} else if s[i] == ')' {
			r++
		}

		if l == r && 2*l > longest {
			longest = 2 * l
		} else if r > l {
			l, r = 0, 0
		}
	}

	l, r = 0, 0
	for i := sLen - 1; i >= 0; i-- {
		if s[i] == '(' {
			l++
		} else if s[i] == ')' {
			r++
		}

		if l == r && 2*l > longest {
			longest = 2 * l
		} else if r < l {
			l, r = 0, 0
		}
	}

	return longest
}

/*
32. 最长有效括号
找到最长有效的括号，很容易想到记录左右括号的数量，可以得到长度
括号肯定 以 （ 开头 ，以 ） 结束
从左往右遍历，如果右括号比左括号多，那肯定不满足了，我们就不看这一部分
如果左右数量相等，就说明满足条件，与最大值比较
核心思想是保持左括号比右括号多，就始终有可能找到满足条件的
有一种情况是左括号始终大于右括号，但其实内部有满足条件的
所以再从右到左遍历一遍，这是要保证右括号始终多余左括号，上面的那种情况这时也能匹配到
*/
