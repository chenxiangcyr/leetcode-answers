/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode p = head;
        List<Integer> list = new ArrayList<Integer>();
        
        while(p != null) {
            list.add(p.val);
            p = p.next;
        }
        
        // O(n log n)
        Collections.sort(list);
        
        p = head;
        int i = 0;
        while(p != null) {
            p.val = list.get(i);
            
            i++;
            p = p.next;
        }
        
        return head;
    }
}
