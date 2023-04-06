/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;

        if(size == 0){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(true){
            int min = -1;
            for(int i = 0; i < size; i++){
                if(lists[i] != null){
                    if(min == -1){
                        min = i;
                    }else{
                        if(lists[i].val < lists[min].val){
                            min = i;
                        }
                    }
                }
            }

            if(min == -1){
                break;
            }else{
                curr.next = lists[min];
                curr = curr.next;

                lists[min] = lists[min].next;
            }
        }

        return dummy.next;
    }
}