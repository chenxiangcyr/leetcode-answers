/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        
        ListNode pre = dummyHead;
        ListNode cur = head;
        
        while(cur != null) {
            while(cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            
            if(pre.next == cur) {
                pre = pre.next;
            }
            else {
                pre.next = cur.next;
            }
            
            cur = cur.next;
        }
        
        return dummyHead.next;
    }
}
