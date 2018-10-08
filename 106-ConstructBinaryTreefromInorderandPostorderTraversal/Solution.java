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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder, int startIn, int endIn, int startPost, int endPost) {
        if(startIn > endIn) {
            return null;
        }
        
        if(startPost > endPost) {
            return null;
        }
        
        // root is the last element of postorder sequence
        TreeNode root = new TreeNode(postorder[endPost]);
        
        if(startPost == endPost) {
            root.left = null;
            root.right = null;
            return root;
        }
        
        // find root position in inorder sequence
        int idx = endIn;
        while(inorder[idx] != root.val) {
            idx--;
        }
        int steps = idx - startIn;
        
        TreeNode left = buildTree(inorder, postorder, startIn, idx - 1, startPost, startPost + steps - 1);
        TreeNode right = buildTree(inorder, postorder, idx + 1, endIn, startPost + steps, endPost - 1);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}
