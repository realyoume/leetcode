class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode last = head, curr = head.next;
        while (curr != null){
            if (curr.val >= last.val){
                last = last.next;
            }else {
                ListNode prev = dummy;
                while (prev.next.val < curr.val){
                    prev = prev.next;
                }
                last.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = last.next;
        }

        return dummy.next;
    }
}
