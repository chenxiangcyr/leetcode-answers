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
    public void flatten(TreeNode root) {
        flattenRecursive(root);
    }
    
    // Return last node after flatten
    public TreeNode flattenRecursive(TreeNode root)
    {
        if(root == null) {
            return root;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        if(left == null && right == null) {
            return root;
        }
        
        TreeNode last = null;
        
        if(left != null)
        {
            last = flattenRecursive(left);
            
            last.left = null;
            last.right = right;
            
            root.left = null;
            root.right = left;
        }
        
        if(right != null)
        {
            last = flattenRecursive(right);
        }
        
        return last;
    }
}
