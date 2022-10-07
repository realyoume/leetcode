package main

func main() {

}

func canFinish(numCourses int, prerequisites [][]int) bool {
	arr := make([]int, numCourses)
	ans := 0

	for i := 0; i < numCourses; i++ {
		arr[i] = 0
	}

	for _, pre := range prerequisites {
		arr[pre[0]]++
	}

	for i := 0; i < numCourses; i++ {
		if arr[i] == 0 {
			arr[i] = -1
			ans++
			for _, pre := range prerequisites {
				if pre[1] == i {
					arr[pre[0]]--
				}
			}
			i = -1
		}
	}

	return ans == numCourses
}

/*
	判断课程在有先修课程的情况下是否能成功修完
	问题转化为有向图中是否存在环
	可以依此去除图中入度为0的节点，并删除以该节点出发的边，最后看图中是否还有节点
	如果全部节点都能去除，那么不存在环，反之则存在环
*/
