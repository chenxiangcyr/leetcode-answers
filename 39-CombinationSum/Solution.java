class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    private List<Integer> path = new ArrayList<Integer>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        travel(candidates, target, 0);
        
        return result;
    }
    
    public void travel(int[] candidates, int target, int startIdx) {
        if(target < 0) {
            return;
        }
        
        else if(target == 0) {
            result.add(new ArrayList<>(path));
        }
        
        else {
            for(int i = startIdx; i < candidates.length; i++) {
                path.add(candidates[i]);
                
                // 递归，依旧从i开始，因为元素可以重复出现多次
                travel(candidates, target - candidates[i], i);
                
                // backtracking
                path.remove(path.size() - 1);
            }
        }
    }
}
