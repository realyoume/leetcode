package main

import (
	"math/rand"
	"time"
)

func main() {

}

/*==== 方法一 ====
快速排序的变形方法，找到数组中第k大的数，时间复杂度只有n
给定一个数组和区间，从中间随机取一个数（这样可用防止极端情况下复杂度过高），找到它在数组中的位置
这时这个数就是数组中第m大的数（m为它的位置）
这样我们要找的数就可以被分到三个区间，左、中、右
用递归继续寻找，直到找到

核心有两个，不断递归缩小区间，直至找到
在区间中随机选一个数，防止极端情况发生

*/

func findKthLargest(nums []int, k int) int {
	rand.Seed(time.Now().UnixNano())
	return quickSelect(nums, 0, len(nums)-1, len(nums)-k)
}

func quickSelect(a []int, l int, r int, index int) int {
	q := randomPartition(a, l, r)
	if q == index {
		return a[q]
	}
	if q < index {
		return quickSelect(a, q+1, r, index)
	}
	return quickSelect(a, l, q-1, index)
}

func randomPartition(a []int, l int, r int) int {
	t := rand.Int()%(r-l+1) + l
	a[t], a[r] = a[r], a[t]
	return partition(a, l, r)
}

func partition(a []int, l int, r int) int {
	t := a[r]
	i := l - 1

	for j := l; j < r; j++ {
		if a[j] < t {
			i++
			a[i], a[j] = a[j], a[i]
		}
	}

	a[i+1], a[r] = a[r], a[i+1]
	return i + 1
}
