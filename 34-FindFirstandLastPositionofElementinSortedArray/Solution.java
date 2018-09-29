class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftRange = binarySearchRange(nums, 0, nums.length - 1, target, true);
        int rightRange = binarySearchRange(nums, 0, nums.length - 1, target, false);
        
        int[] result = new int[] {leftRange, rightRange};
        return result;
    }
    
    // binary search solution
    public int binarySearchRange(int[] nums, int start, int end, int target, boolean isLeft) {
        while(start <= end) {
            int middle = (start + end) / 2;
            
            if(nums[middle] < target) {
                start = middle + 1;
            }
            
            if(nums[middle] > target) {
                end = middle - 1;
            }
            
            // the case nums[middle] == target
            if(nums[middle] == target) {
                // want to find left range
                if(isLeft == true) {
                    if(middle == 0 || nums[middle - 1] != target) {
                        return middle;
                    }
                    else {
                        end = middle - 1;
                    }
                }
                // want to find right range
                else {
                    if(middle == nums.length - 1 || nums[middle + 1] != target) {
                        return middle;
                    }
                    else {
                        start = middle + 1;
                    }
                }
            }
        }
        
        return -1;
    }
}
