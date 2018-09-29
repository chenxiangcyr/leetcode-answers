class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int result = nums[0] + nums[1] + nums[2];
        
        // 排序
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            int low_idx = i + 1;
            int high_idx = nums.length - 1;
            
            while(low_idx < high_idx) {
                int sum = nums[i] + nums[low_idx] + nums[high_idx];
                
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                
                if(sum < target) {
                    low_idx++;
                }
                else {
                    high_idx--;
                }
            }
        }
        
        return result;
        
    }
}
