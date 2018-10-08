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

        if (root == null) {
            return;
        }
        
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findNextNode(root.next);
            }
        }
        
        if (root.right != null) {
            root.right.next = findNextNode(root.next);
        }
        
        connect(root.right);
        connect(root.left);

    }
    
    private TreeLinkNode findNextNode(TreeLinkNode node) {
        
        if (node == null) {
            return null;
        }
        
        if (node.left != null) {
            return node.left;
        }
        
        if (node.right != null) {
            return node.right;
        }
        
        return findNextNode(node.next);
    }
}
