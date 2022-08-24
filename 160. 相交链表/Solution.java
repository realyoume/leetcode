public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //集合记录走过的节点
//        Set<ListNode> visited = new HashSet<ListNode>();
//        ListNode temp = headA;
//        while (temp != null) {
//            visited.add(temp);
//            temp = temp.next;
//        }
//        temp = headB;
//        while (temp != null) {
//            if (visited.contains(temp)) {
//                return temp;
//            }
//            temp = temp.next;
//        }
//        return null;


        // 双指针
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;

    }
}
/*
    集合记录是比较基础的方法，和双指针相比显得笨重，两者时间复杂度差不多，但用了额外的空间去记录节点
    自己也能想到双指针，但是双指针怎么走却不知道
    两个指针以相同的速度跑完两段路，一定是同时到达终点，如果两端路的后面重合，那么一定在终点前就到达相同的位置
    位置相同的第一个节点就是两个链表交会的节点

 */

