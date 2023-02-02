package main

func main() {

}

func trap(height []int) int {
	size := len(height)

	if size == 0 || size == 1 {
		return 0
	}

	max := height[0]
	index := 0
	count := 0
	for i := 0; i < size; i++ {
		if max < height[i] {
			max = height[i]
			index = i
		}
		count += height[i]
	}

	sum := 0
	temp := height[0]
	for i := 0; i < index; i++ {
		if height[i] > temp {
			temp = height[i]
		}

		sum += max - temp
	}

	temp = height[size-1]
	for i := size - 1; i > index; i-- {
		if height[i] > temp {
			temp = height[i]
		}

		sum += max - temp
	}

	return max*size - sum - count
}

/*
42. 接雨水
我写了一种数空气的方法，效果还可以
正常思路还是找到每一格左边和右边最高的地方，就可以算出能接多少雨水
这一过程可以用动态规划来简化， maxLeft[i] = max (maxLeft[i-1], height[i])
两个方向都遍历一遍就可以得到两个数组

也可以用左右两个指针，因为取决于左右高度的最小值，所以我们先看高度低的那一个，
只要左边高度小于右边，那么左边的最大高度一定小于右边的最大高度，因为我们每次都移动高度低的那一个，结果就是左右指针向中靠拢，在到达比另一个指针高的地方停下来
每次移动时根据自己这边的最大高度算就行，因为另一半肯定超过了
*/
