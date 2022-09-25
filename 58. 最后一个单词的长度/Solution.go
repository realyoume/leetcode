package main

import (
	"strings"
)

func main() {

}

func lengthOfLastWord(s string) int {
	s = strings.TrimSpace(s)
	index := strings.LastIndex(s, " ")
	return len(s) - index - 1
}
