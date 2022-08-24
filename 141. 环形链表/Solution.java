public class Solution {
    //哈希表
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> seen = new HashSet<ListNode>();
//        while (head != null) {
//            if (!seen.add(head)) {
//                return true;
//            }
//            head = head.next;
//        }
//        return false;
//    }

    // Floyd算法，快慢指针
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast){
            if(fast.next == null || fast.next.next == null){
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }
}

/*
    可以用哈希set记录所有已经走过的节点，如果遇到相同的节点，就说明链表存在环，如果能走到尽头，说明没有环
    时间复杂度O（N），最坏每个节点一次
    空间复杂度O（N），哈希表中每个节点一次

    Floyd算法，快慢指针
    一快一慢两个指针，如果不存在环，那么快指针会走到尽头
    如果存在环，那么快指针会先进入环并在环中转圈，等慢指针同样进入环中，那么快慢指针一定会存在相遇的时刻
    如果我们发现快慢指针指向同一节点，就说明链表中存在环
    时间复杂度O（N），最坏情况转圈也只会重复N次
    空间复杂度O（1），只会使用两个额外的指针
 */