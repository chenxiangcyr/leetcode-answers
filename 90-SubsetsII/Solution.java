class Solution {
    public List<List<Integer>> subsets = new ArrayList<List<Integer>>();
    public List<Integer> subset = new ArrayList<Integer>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 排序
        Arrays.sort(nums);
        
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
            
            // 避免重复元素出现
            while(i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
    }
}
