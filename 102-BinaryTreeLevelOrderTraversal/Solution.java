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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> level = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);
        
        while(!queue.isEmpty()) {
            TreeNode top = queue.poll();
            
            if(top != null) {
                level.add(top.val);
                
                if(top.left != null) {
                    queue.offer(top.left);
                }

                if(top.right != null) {
                    queue.offer(top.right);
                }
            }
            else {
                result.add(level);
                level = new ArrayList<Integer>();
                
                if(!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }
        
        return result;
    }
}
