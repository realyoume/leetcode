package main

import (
	"fmt"
	"strings"
)

func main() {
	arr := []int{1, 2, 3}
	arr = append(arr[:2], append([]int{4}, arr[2:]...)...)
	fmt.Println(arr)
}

func lengthOfLastWord(s string) int {
	s = strings.TrimSpace(s)
	index := strings.LastIndex(s, " ")
	return len(s) - index - 1
}
