/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode dummy = dummyHead;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        while(p1 != null && p2 != null) {
            if(p1.val <= p2.val) {
                dummy.next = p1;
                
                p1 = p1.next;
            }
            else {
                dummy.next = p2;
                
                p2 = p2.next;
            }
            
            dummy = dummy.next;
        }
        
        if(p1 != null) {
            dummy.next = p1;
        }else {
            dummy.next = p2;
        }
        
        return dummyHead.next;
    }
}
