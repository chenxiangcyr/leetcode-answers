/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        // Refer: https://leetcode.com/problems/insertion-sort-list/discuss/160946/5-ms-solution-Beats-97-Java
        
        if (head == null) return head;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        
       // Look for next item to be inserted
        while (fast != null) {
            // Insert fast to the end of the list
            if (fast.val >= slow.val) {
                slow = slow.next;
                fast = fast.next;
            }
            //Insert to the beggining of the list
            else if (fast.val < head.val){
                ListNode cur = fast;
                // Advance fast pointer to not lose information about the rest of the list
                fast = fast.next;
                // Create next reference to begining of the list
                cur.next = head;
                // Update the head title
                head = cur;
                // Update slow's pointer to the end of the list
                slow.next = fast; 
            }
            // General case
            else {
                ListNode cur = head.next; // Can assum
                ListNode prev = head;
                
                while (fast.val > cur.val){ // Search for correct position
                    prev = cur;
                    cur = cur.next;
                }
                // Ends we know that fast.val <= cur.val so insert between pre and cr
                
                // Save reference to fast pointer since we are about to advance the fat pointer
                ListNode oldFast = fast;
                // Advance fast pointer so we don't lose information about end of the list
                fast = fast.next;
                // Update slow to point to the end of the list
                slow.next = fast;
                
                // Connect insert value into correct place
                prev.next = oldFast;
                oldFast.next = cur;
            }
        }
        
        return head;
    }
}
