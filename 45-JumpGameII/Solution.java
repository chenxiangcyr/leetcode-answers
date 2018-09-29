class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        
        if(n < 2) {
            return 0;
        }
        
	    int level = 0;
        int currentMax = 0;
        int i = 0;
        int nextMax = 0;

        // nodes count of current level > 0
        while(currentMax - i + 1 > 0){
            level++;
            
            // traverse current level, and update the max reach of next level
		    for(; i <= currentMax; i++) {
			    nextMax = Math.max(nextMax, nums[i] + i);
                
                // if last element is in level+1,  then the min jump = level 
			    if(nextMax >= n - 1) {
                    return level;
                }
		    }
            
		    currentMax = nextMax;
	    }
        
	    return 0;
    }
}
