/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }
    
    TreeNode sortedListToBST(ListNode begin, ListNode end)
    {
        if(begin == end)
            return null;
        
        // Find the middle node
        ListNode fast_node = begin;
        ListNode slow_node = begin;
        
        while(fast_node != end && fast_node.next != end)
        {
            fast_node = fast_node.next.next;
            slow_node = slow_node.next;
        }
        
        TreeNode root = new TreeNode(slow_node.val);
        root.left = sortedListToBST(begin, slow_node);
        root.right = sortedListToBST(slow_node.next, end);
        
        return root;
    }
}
