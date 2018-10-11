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
    int sum = 0;
    StringBuilder path = new StringBuilder();
    
    public int sumNumbers(TreeNode root) {
        dfs(root);
        
        return sum;
    }
    
    public void dfs(TreeNode root) {
        if(root == null) return;
        
        path.append(root.val);
        
        // 达到叶子节点，累加sum
        if(root.left == null && root.right == null) {
            sum = sum + Integer.parseInt(path.toString());
        }
        else {
            dfs(root.left);
            dfs(root.right);
        }
        
        // backtracking
        path = path.deleteCharAt(path.length() - 1);
    }
}
