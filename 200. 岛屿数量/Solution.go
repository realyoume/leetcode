package main

func main() {

}

func numIslands(grid [][]byte) (count int) {
	m := len(grid)
	n := len(grid[0])
	count = 0

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == '1' {
				fillLands(i, j, m, n, grid)
				count++
			}
		}
	}

	return
}

var dirs [][]int = [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}

func inBlock(i int, j int, m int, n int) bool {
	return i < m && i >= 0 && j < n && j >= 0
}

func fillLands(i int, j int, m int, n int, grid [][]byte) {
	grid[i][j] = '2'
	for _, dir := range dirs {
		if inBlock(i+dir[0], j+dir[1], m, n) && grid[i+dir[0]][j+dir[1]] == '1' {
			fillLands(i+dir[0], j+dir[1], m, n, grid)
		}
	}
}

/*
	寻找岛屿的数量，在一个二维数组中
	用深度优先搜索，每当我们找到陆地，也就是大小为1的格子，我们将这片陆地以及周围的土地都标记为2（用递归的方式），这样探索完整片大陆
	接着我们寻找新的陆地，我们能找到多少块陆地，也就有多少岛屿
*/
