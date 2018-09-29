class Solution {
    public List<List<Integer>> subsets = new ArrayList<List<Integer>>();
    public List<Integer> subset = new ArrayList<Integer>();
    
    public List<List<Integer>> subsets(int[] nums) {
        travel(nums, 0);
        
        subsets.add(new ArrayList<Integer>());
        
        return subsets;
    }
    
    public void travel(int[] nums, int startIdx) {
        for(int i = startIdx; i < nums.length; i++) {
            subset.add(nums[i]);

            subsets.add(new ArrayList(subset));
            
            if(i + 1 < nums.length) {
                travel(nums, i + 1);
            }

            // backtracking
            subset.remove(subset.size() - 1);
        }
    }
}
