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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, (long)Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE + 1);
    }
    
    public boolean isValidBST(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        
        if(root.val <= min || root.val >= max) {
            return false;
        }
        
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
