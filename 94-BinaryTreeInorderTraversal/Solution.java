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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> inOder = new ArrayList<Integer>();
        
        // iterative solution
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        boolean flag = false;
        
        if(root != null) {
            TreeNode p = root;
            
            stack.push(p);
            
            while(!stack.isEmpty()) {
                p = stack.peek();
                
                // find leftmost
                while(flag == false && p.left != null) {
                    stack.push(p.left);

                    p = p.left;
                }
                
                p = stack.pop();
                
                inOder.add(p.val);
                
                if(p.right != null) {
                    stack.push(p.right);
                    flag = false;
                } else {
                    flag = true;
                }
            }
        }
        
        return inOder;
    }
}
