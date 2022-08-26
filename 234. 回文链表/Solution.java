class Solution {
    public boolean isPalindrome(ListNode head) {
        StringBuffer stringBuffer = new StringBuffer(new String(""));

        while (head != null){
            stringBuffer.append(head.val);
            head = head.next;
        }

        String s1 = stringBuffer.toString();
        String s2 = stringBuffer.reverse().toString();

        if(s1.equals(s2)){
            return true;
        }else {
            return false;
        }
    }
}

/*
    0 我写的这个和1类似，不过因为数字是0-9，就用string来存储和反转，写起来简单一些
    1 遍历存储到数组后进行双指针比较
        时间复杂度 n 至少要遍历一遍
        空间复杂度 n 用额外的空间储存数组
    2 快慢指针找到链表的中间，将后段的链表反转，再逐一比较，最后将链表恢复
        时间复杂度 n 至少遍历一遍
        空间复杂度 1 不需要额外的空间
        比较复杂一些
        快慢指针考虑链表长度的奇偶情况
        反转后段链表要用之前的知识
        依此比较简单
        恢复链表又要反转一次
        在多线程的条件下不适用，因为改变了链表本身的状态
 */