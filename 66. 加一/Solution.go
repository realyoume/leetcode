package main

func main() {
	a := []int{9, 9}
	plusOne(a)
}

func plusOne(digits []int) []int {
	index := len(digits) - 1
	digits[index] += 1

	for i := index; i >= 0; i-- {
		if digits[i] == 10 {
			digits[i] = 0
			if i == 0 {
				digits = append([]int{1}, digits...)
				return digits
			} else {
				digits[i-1] += 1
			}
		} else {
			return digits
		}
	}

	return digits
}
