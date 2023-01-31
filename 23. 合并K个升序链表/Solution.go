package main

func main() {

}

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeKLists(lists []*ListNode) *ListNode {
	size := len(lists)
	if size == 0 {
		return nil
	}

	var rs, temp, target *ListNode

	for true {
		temp = nil
		for i := 0; i < size; i++ {
			if lists[i] != nil {
				temp = lists[i]
				break
			}
		}

		if temp == nil {
			break
		}

		count := 0
		for i := 0; i < size; i++ {
			if lists[i] != nil && lists[i].Val <= temp.Val {
				temp = lists[i]
				count = i
			}
		}
		lists[count] = lists[count].Next

		if rs == nil {
			rs = temp
			target = rs
		} else {
			target.Next = temp
			target = temp
		}
	}

	return rs
}

/*
23. 合并K个升序链表
之前有写过合并两个升序链表，合并多个时，可以每次合并两个，这样可以实现
进一步的，用分治法将其两两合并，时间复杂度更低

也可以同时将多个链表的头进行比较，选出最小的那一个，放入答案中，最后返回头即可
*/
