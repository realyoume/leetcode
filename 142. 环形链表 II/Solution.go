package main

func main() {

}

type ListNode struct {
	Val  int
	Next *ListNode
}

// 哈希表存储已经遇到的节点
//func detectCycle(head *ListNode) *ListNode {
//	seen := map[*ListNode]bool{}
//
//	for head != nil {
//		if _, ok := seen[head]; ok {
//			return head
//		}
//
//		seen[head] = true
//		head = head.Next
//	}
//
//	return nil
//}

// 快慢指针
func detectCycle(head *ListNode) *ListNode {
	fast, slow := head, head

	for fast != nil {
		slow = slow.Next
		if fast.Next == nil {
			return nil
		}
		fast = fast.Next.Next

		if fast == slow {
			p := head
			for p != slow {
				p = p.Next
				slow = slow.Next
			}
			return p
		}
	}
	return nil
}

/*
	自己写的超过了时间限制
	方法一是用哈希表存储已经遇到的节点，依此遍历节点，没有遇到的就加入，如果碰到已经存在的，说明是环的开始，直接返回即可
	方法二是快慢指针，如果有环的话总会相遇，计算一下相遇时走过的路程关系，再构建一个指针就能找到环的开始
	方法二的空间复杂度小，但是不容易想到
*/
