package main

func main() {

}

//func longestConsecutive(nums []int) int {
//	length := len(nums)
//	sort.Ints(nums)
//	ans := 0
//	temp := 1
//	yu := 0
//
//	for i := 0; i < length; {
//		temp = 1
//		yu = 0
//		for i+temp < length {
//			if nums[i+temp]-nums[i+temp-1] == 0 {
//				temp++
//				yu++
//			} else if nums[i+temp]-nums[i+temp-1] == 1 {
//				temp++
//			} else {
//				break
//			}
//
//		}
//
//		if temp-yu > ans {
//			ans = temp - yu
//		}
//
//		i += temp
//	}
//
//	return ans
//}

func longestConsecutive(nums []int) int {
	numSet := make(map[int]bool)
	for _, val := range nums {
		numSet[val] = true
	}

	longest := 0

	for num := range numSet {
		if !numSet[num-1] {
			current := 1

			for numSet[num+current] {
				current++
			}

			if current > longest {
				longest = current
			}
		}
	}
	return longest
}

/*
	写了两种不同的方法，结果我写的反而复杂度低一些
	我是先排序，再依此遍历，最多只走一遍
	标准答案用了hashmap，存储方便查询，剪枝了中间的数，
	我想还是查询次数太多，比不了数组直接查位置的速度
*/
