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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }
    
    public int depth(TreeNode root) {
        if(root == null) return 0;
        
        int left = depth(root.left);
        int right = depth(root.right);
        
        return Math.max(left, right) + 1;
    }
}
