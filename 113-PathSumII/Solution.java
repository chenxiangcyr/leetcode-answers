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
    public List<List<Integer>> allPath = new ArrayList<List<Integer>>();
    public List<Integer> path = new ArrayList<Integer>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        getAllPath(root);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for(List<Integer> path : allPath) {
            int t = 0;
            for(Integer i : path) {
                t = t + i;
            }
            
            if(t == sum) {
                result.add(path);
            }
        }
        
        return result;
    }
    
    public void getAllPath(TreeNode root) {
        if(root == null) return;
        
        path.add(root.val);
        
        // if is leaf, add one path
        if(root.left == null && root.right == null) {
            allPath.add(new ArrayList(path));
        }
        else {
            getAllPath(root.left);
            getAllPath(root.right);
        }
        
        // backtracking
        path.remove(path.size() - 1);
    }
}
