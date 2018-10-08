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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> zigzag = new ArrayList<List<Integer>>();
        
        if(root != null) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            
            queue.offer(root);
            queue.offer(null);

            int flag = 0;
            
            List<Integer> level = new ArrayList<Integer>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                
                if(node != null) {
                    level.add(node.val);
                    
                    if(node.left != null) {
                        queue.offer(node.left);
                    }

                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                }
                // a new level
                else {
                    if(flag == 0) {
                        zigzag.add(level);
                    }
                    else {
                        Collections.reverse(level);
                        
                        zigzag.add(level);
                    }
                    level = new ArrayList<Integer>();
                    
                    if(!queue.isEmpty()) {
                        queue.offer(null);
                    }
                    
                    flag = flag ^ 1;
                }
            }
        }
        
        return zigzag;
    }
}
