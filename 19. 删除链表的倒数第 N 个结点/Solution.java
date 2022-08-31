class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode n1 = head;
//        ListNode n2 = head;
//
//        while (n > 0){
//            n1 = n1.next;
//            --n;
//        }
//
//        if(n1 == null){
//            return head.next;
//        }
//
//        n1 = n1.next;
//
//        while (n1 != null){
//            n1 = n1.next;
//            n2 = n2.next;
//        }
//
//        n2.next = n2.next.next;
//
//        return head;

        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}

/*
    双指针，思路都一样，标准答案比我写的更简洁一些
    用了一个dummy节点，这样删除头节点的时候不用特判
    慢指针也可以直接就位
 */