class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    
    // binary search solution
    public int binarySearch(int[] nums, int start, int end, int target) {
        
        while(start <= end) {
            int middle =  (start + end) / 2;
            
            if(nums[middle] == target) {
                return middle;
            }
            
            // 左边升序
            if (nums[start] <= nums[middle]) {
                 if (target < nums[middle] && target >= nums[start]) {
                    end = middle - 1;
                 }
                 else {
                    start = middle + 1;
                 }
            }
            // 右边升序
            else {
                if (target > nums[middle] && target <= nums[end]) {
                    start = middle + 1;
                }
                else {
                    end = middle - 1;
                }
            }
        }
        
        return -1;
    }
}
