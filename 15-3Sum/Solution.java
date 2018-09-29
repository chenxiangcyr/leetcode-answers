class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);
    }
    
    public List<List<Integer>> threeSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        // 排序
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            // 避免重复数字
            while(i > 0 && i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i++;
            }
            
            int low_idx = i + 1;
            int high_idx = nums.length - 1;
            
            int remaining = target - nums[i];
            
            while(low_idx < high_idx) {
                if(nums[low_idx] + nums[high_idx] < remaining) {
                    low_idx++;
                }
                
                else if (nums[low_idx] + nums[high_idx] > remaining) {
                    high_idx--;
                }
                
                else {
                    result.add(Arrays.asList(nums[i], nums[low_idx], nums[high_idx]));
                    
                    // 避免重复数字
                    low_idx++;
                    while(low_idx < high_idx && nums[low_idx] == nums[low_idx - 1]) {
                        low_idx++;
                    }
                    
                    // 避免重复数字
                    high_idx--;
                    while(low_idx < high_idx && nums[high_idx] == nums[high_idx + 1]) {
                        high_idx--;
                    }
                }
            }
        }
        
        return result;
    }
}


