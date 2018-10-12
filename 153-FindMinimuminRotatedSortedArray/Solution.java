class Solution {
    public int findMin(int[] nums) {
        
        if(nums == null && nums.length == 0) return 0;
        
        int i = 0;
        int j = nums.length-1;
        
        // Binary search
        while(i < j) {
            int mid = (i + j)/2;
            
            // right part
            if(nums[mid] > nums[j]) {
                i = mid + 1;
            }
            // right part or current mid
            else {
                j = mid;
            }
        }
        
        return nums[i];
    }
}
