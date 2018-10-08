/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        connect(root, null);
    }
    
    public void connect(TreeLinkNode node, TreeLinkNode rightNode) {
        if(node == null) {
            return;
        }
        
        if(node.left == null || node.right == null) {
            return;
        }
        
        node.left.next = node.right;
        node.right.next = rightNode != null ? rightNode.left : null;
        
        // recursive solution
        connect(node.left, node.right);
        connect(node.right, rightNode != null ? rightNode.left : null);
    }
}
