class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i] means the maximum subarray ending with A[i]
        int[] dp = new int[nums.length];
        
        // init
        dp[0] = nums[0];
        int max = dp[0];
        
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
    
    public int maxSubArrayOld(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                
                max = Math.max(max, sum);
            }
        }
        
        return max;
    }
}
