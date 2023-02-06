package main

func main() {

}

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	var prev *ListNode
	curr := head
	for curr != nil {
		next := curr.Next
		curr.Next = prev
		prev = curr
		curr = next
	}
	return prev
}

/*
剑指 Offer 24. 反转链表
很基础的反转链表题目，闭着眼睛写这种
一前一后三个指针，向后滑动
*/
