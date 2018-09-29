/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        int carry = 0;
        while(p1 != null || p2 != null) {
            int sum = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + carry;
            
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            
            p.next = node;
            p = node;
            
            if(p1 != null) p1 = p1.next;
            if(p2 != null) p2 = p2.next;
        }
        
        if(carry == 1) {
            ListNode node = new ListNode(1);
            
            p.next = node;
            p = node;
        }
        
        p.next = null;
        
        return dummyHead.next;
    }
}
