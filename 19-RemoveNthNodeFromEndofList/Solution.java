/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // two pointer strategy
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        
        for(int i = 0; i <= n; i++) {
            p1 = p1.next;
        }
        
        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        p2.next = p2.next.next;
        
        return dummy.next;
    }
}
