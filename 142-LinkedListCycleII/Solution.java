/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        
        // two pointer strategy
        ListNode p1 = head;
        ListNode p2 = head;
        
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            
            if(p1 == p2) {
                break;
            }
        }
        
        if(p1 != p2) {
            return null;
        }
        
        ListNode p = head;
        while(p != p2) {
            p = p.next;
            p2 = p2.next;
        }
        
        return p;
    }
}
