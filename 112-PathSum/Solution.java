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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        
        // if leaf
        if(root.left == null && root.right == null) {
            if(root.val == sum) {
                return true;
            }
            else {
                return false;
            }
        }
        // if not leaf, recursive on left sub tree and right sub tree
        else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
