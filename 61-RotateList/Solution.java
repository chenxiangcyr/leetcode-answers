/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        
        int listLength = 0;
        ListNode p = head;
        // 计算链表长度
        while(p != null) {
            listLength++;
            p = p.next;
        }
        
        // 双指针策略
        ListNode p1 = head;
        ListNode p2 = head;
        
        // 处理 k >= 链表长度的情况
        k = k % listLength;
        
        for(int i = 0; i < k; i++) {
            p2 = p2.next;
        }
        
        // 说明不需要转置
        if(p1 == p2) return head;
        
        while(p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        ListNode newHead = p1.next;
        
        p1.next = null;
        p2.next = head;
        
        return newHead;
    }
}
