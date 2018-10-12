class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        // DP Iterative solution
        // max[i] is the max product if include nums[i]
        int[] max = new int[nums.length];
        // min[i] is the min product if include nums[i]
        int[] min = new int[nums.length];
        
        // init
        max[0] = nums[0];
        min[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            /*
            get the max and min among:
                * max[i - 1] * nums[i]
                * min[i - 1] * nums[i]
                * nums[i]
            */
            
            max[i] = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
        }
        
        int result = max[0];
        for(int i = 1; i < nums.length; i++) {
            result = Math.max(result, max[i]);
        }
        
        return result;
    }
}
