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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        postorderTraversal(root, result);
        
        return result;
    }
    
    public void postorderTraversal(TreeNode root, List<Integer> result) {
        if(root != null) {
            postorderTraversal(root.left, result);
            postorderTraversal(root.right, result);
            
            result.add(root.val);
        }
    }
}
