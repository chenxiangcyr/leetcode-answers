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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int startPre, int endPre, int startIn, int endIn) {
        if(startPre > endPre) {
            return null;
        }
        
        if(startIn > endIn) {
            return null;
        }
        
        // root is the first element of preoder sequence
        TreeNode root = new TreeNode(preorder[startPre]);
        
        if(startPre == endPre) {
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
        
        TreeNode left = buildTree(preorder, inorder, startPre + 1, startPre + steps, startIn, idx - 1);
        TreeNode right = buildTree(preorder, inorder, startPre + steps + 1, endPre, idx + 1, endIn);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}
