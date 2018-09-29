class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    private List<Integer> path = new ArrayList<Integer>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                // 跳过重复的元素
                if(i > startIdx && candidates[i] == candidates[i-1]) {
                    continue;
                }
                
                path.add(candidates[i]);
                
                // 递归，从i + 1开始，因为元素只能出现一次
                travel(candidates, target - candidates[i], i + 1);
                
                // backtracking
                path.remove(path.size() - 1);
            }
        }
    }
}
