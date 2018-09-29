/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode begin;
        
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        begin = dummyHead;
        
        int i = 0;
        while (head != null) {
            i++;
            
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        
        return dummyHead.next;
    }

    public ListNode reverse(ListNode begin, ListNode end) {
        
        ListNode prev = begin;
        ListNode curr = begin.next;
        ListNode next;
        ListNode first = curr;
        
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        begin.next = prev;
        first.next = curr;
        
        return first;
    }
}
