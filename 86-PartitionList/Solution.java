/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;
        
        while (head != null){
            if (head.val < x) {
                curr1.next = head;
                curr1 = curr1.next;
            } 
            else {
                curr2.next = head;
                curr2 = curr2.next;
            }
            
            head = head.next;
        }
        
        curr2.next = null;
        curr1.next = dummy2.next;
        
        return dummy1.next;
    }
}
