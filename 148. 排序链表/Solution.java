
class Solution {
    public  static ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        int len = 0;
        ListNode temp = head;
        while (temp != null){
            temp = temp.next;
            len++;
        }

        for (int i = 1; i <= len; i <<= 1) {
            ListNode prev = dummy, curr = dummy.next;

            while (curr != null){
                ListNode head1 = curr;
                for (int j = 1; j < i && curr.next != null; ++j) {
                    curr = curr.next;
                }

                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;

                for (int j = 1; j < i && curr != null; ++j) {
                    curr = curr.next;
                }

                if (curr != null){
                    temp = curr.next;
                    curr.next = null;
                    curr = temp;
                }


                prev.next = merger(head1, head2);

                while (prev.next != null){
                    prev = prev.next;
                }

            }
        }

        return dummy.next;
    }

    public static ListNode merger(ListNode head1, ListNode head2){

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (head1 != null && head2 != null){
            if (head1.val < head2.val){
                temp.next = head1;
                head1 = head1.next;
            }else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if (head1 == null){
            temp.next = head2;
        }else {
            temp.next = head1;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(4, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(5, n3);
        ListNode n5 = new ListNode(-1, n4);

        sortList(n5);
    }
}