/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        
        ListNode pA = headA;
        ListNode pB = headB;

        /*
        Maintain two pointers pA and pB initialized at the head of A and B, respectively.
        Then let them both traverse through the lists, one node at a time.
        When pA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.);
        similarly when pB reaches the end of a list, redirect it the head of A.
        If at any point pA meets pB, then pA/pB is the intersection node.
        */
        while( pA != pB){
            pA = (pA != null? pA.next : headB);
            pB = (pB != null? pB.next : headA);    
        }

        return pA;
    }
}
