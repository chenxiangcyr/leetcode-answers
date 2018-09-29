class Solution {
    public boolean canJump(int[] nums) {
        return canJumpToPostionIterative(nums);
    }
    
    // DP iterative, bottom-up
    public boolean canJumpToPostionIterative(int[] nums) {
        // canArrive[i] 表示能否达到位置i
        int[] canArrive = new int[nums.length];
        Arrays.fill(canArrive, 0);
        
        // 初始化，能够达到位置0
        canArrive[0] = 1;
        
        // 依次遍历其他位置 i
        for(int i = 1; i <= nums.length - 1; i++) {
            for(int j = i - 1; j >= 0; j--) {
                // 能够从之前的位置 j 跳到当前位置 i
                if(canArrive[j] == 1 && nums[j] >= (i - j)) {
                    canArrive[i] = 1;
                    break;
                }
            }
        }
        
        return canArrive[nums.length - 1] == 1;
    }
    
    // DP recursive, top-down - Time Limit Exceeded
    public boolean canJumpToPostionRecursive(int[] nums, int position) {
        if(position == 0) {
            return true;
        }
        
        for(int i = position - 1; i >= 0; i--) {
            // from i to postion
            if(canJumpToPostionRecursive(nums, i) && nums[i] >= (position - i)) {
                return true;
            }
        }
        
        return false;
    }
}
