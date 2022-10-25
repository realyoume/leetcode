package main

func main() {

}

//func searchMatrix(matrix [][]int, target int) bool {
//	m := len(matrix)
//	n := len(matrix[0])
//	m1, n1, m2, n2 := -1, -1, m, n
//
//	for i := 0; i < m; i++ {
//		if matrix[i][0] > target {
//			m2 = i
//			break
//		}
//	}
//	for i := 0; i < n; i++ {
//		if matrix[0][i] > target {
//			n2 = i
//			break
//		}
//	}
//
//	for i := m2 - 1; i >= 0; i-- {
//		if matrix[i][n2-1] < target {
//			m1 = i
//			break
//		}
//	}
//
//	for i := n2 - 1; i >= 0; i-- {
//		if matrix[m2-1][i] < target {
//			n1 = i
//			break
//		}
//	}
//
//	for i := m1 + 1; i < m2; i++ {
//		for j := n1 + 1; j < n2; j++ {
//			if matrix[i][j] == target {
//				return true
//			}
//		}
//	}
//
//	return false
//}

func searchMatrix(matrix [][]int, target int) bool {
	m, n := len(matrix), len(matrix[0])
	x, y := 0, n-1

	for x < m && y >= 0 {
		if matrix[x][y] == target {
			return true
		}

		if matrix[x][y] > target {
			y--
		} else {
			x++
		}
	}
	return false
}

/*
	我的想法有点答案的意思，但是没有完全得到这道题的精髓
	列和行都是递增，来找一个数，怎么找比较块呢
	很显然，我们可以通过一些比较，就排除掉矩阵中的一些元素
	想过从左上角，右下角开始，结果竟然是从右上角开始，
	这个就决定了可以移动的方向，只有同时右两个方向的移动才能保证能哦按段万整个矩阵
	这样才能快速得到结果
*/
